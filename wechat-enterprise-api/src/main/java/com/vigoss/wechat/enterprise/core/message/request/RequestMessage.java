package com.vigoss.wechat.enterprise.core.message.request;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Node;

import com.vigoss.wechat.enterprise.core.message.Message;
import com.vigoss.wechat.enterprise.core.pojo.ConnList;
import com.vigoss.wechat.enterprise.core.pojo.WxUserInfo;





/**
 * 请求类型消息的抽象类，请求类型的消息必须实现该抽象类。
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class RequestMessage extends Message {

	private static Log log = LogFactory.getLog(RequestMessage.class);

	private static final long USERINFO_UPDATE_TIME = 7 * 24 * 60 * 60 * 1000L;
	protected WxUserInfo currentUserInfo;
	protected String localAddr;
	
	protected String firstflag="N";//首次关注标识 N:不是首次关注 Y:是首次关注
	/**
	 * 构造方法
	 * 
	 * @param accountId
	 * @param xmlDoc
	 */
	public RequestMessage(String accountId, Document xmlDoc) {
		this.accountId = accountId;
		this.toUserName = xmlDoc.selectSingleNode("/xml/ToUserName").getText();
		this.fromUserName = xmlDoc.selectSingleNode("/xml/FromUserName")
				.getText();
		this.msgId = xmlDoc.selectSingleNode("/xml/MsgId") == null ? ""	: xmlDoc.selectSingleNode("/xml/MsgId").getText();
		this.agentId = xmlDoc.selectSingleNode("/xml/AgentID").getText();
		this.msgType = xmlDoc.selectSingleNode("/xml/MsgType").getText();
		this.content = xmlDoc.selectSingleNode("/xml/Content") == null ? "" : xmlDoc.selectSingleNode("/xml/Content").getText();

		try {
			
//			RegisterDao registerDao = (RegisterDao) DatabaseHelper
//					.getBean(RegisterDao.class);
			
//			ConnList connList = registerDao.getConnListInfoByUseridAndAccountid(fromUserName, accountId);
			ConnList connList = new ConnList();;
			Node node = xmlDoc.selectSingleNode("/xml/Event");
			boolean subs=true;
			if(node !=null){
				// 关注/取消事件
				if("subscribe".equals(node.getText())){
					log.info("关注事件");
					subs=false;
					if (connList == null) {
						firstflag="Y";
					}else{
						log.info("更新关注状态"+fromUserName);
					}
					
				}else if("unsubscribe".equals(node.getText())){
					log.info("取消关注事件");
					subs=false;
					if (connList == null) {
						firstflag="Y";
					}else{
						log.info("更新取消关注状态"+fromUserName);
					}
				}
			}
			// 非关注/取消事件
			if(subs){
				log.info("非关注/取消事件");
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	/**
	 * 获取属性：请求的地址(IP)
	 * 
	 * @return
	 */
	public String getLocalAddr() {
		return localAddr;
	}

	/**
	 * 设置属性：请求的地址(IP)
	 * 
	 * @param localAddr
	 */
	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	/**
	 * 获取消息渠道
	 */
	@Override
	protected int getUserSend() {
		return 1;
	}

	/**
	 * 转换为xml字符串
	 */
	@Override
	public final String toString() {
		StringBuilder out = new StringBuilder();
		out.append("\n<xml>\n");
		out.append("	<ToUserName>").append(this.toUserName).append("</ToUserName>\n");
		out.append("	<FromUserName>").append(this.fromUserName).append("</FromUserName>\n");
		out.append("	<CreateTime>").append(this.getCreateTime().getTime()).append("</CreateTime>\n");		
		out.append("	<MsgType>").append(this.msgType).append("</MsgType>\n");
		out.append("	<Content>").append(this.content).append("</Content>\n");
		out.append("	<MsgId>").append(this.msgId).append("</MsgId>\n");
		out.append("	<AgentID>").append(this.getAgentId()).append("</AgentID>\n");
		
		this.toString(out);	
		out.append("</xml>\n");
		
		return out.toString();
	}

	/**
	 * 转换为xml字符串
	 * 
	 * @param out
	 */
	protected abstract void toString(StringBuilder out);

	public String getFirstflag() {
		return firstflag;
	}

	public void setFirstflag(String firstflag) {
		this.firstflag = firstflag;
	}

}
