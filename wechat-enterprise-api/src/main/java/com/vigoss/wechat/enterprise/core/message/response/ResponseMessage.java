package com.vigoss.wechat.enterprise.core.message.response;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.Message;
import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;

/**
 * 响应消息的抽象类，响应类型的消息必须实现该抽象类。
 * 
 * @author cypei
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class ResponseMessage extends Message {

	// 表示流程是否处理结束
	private boolean endFlag = false;

	/**
	 * 构造方法
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param accountId
	 */
	public ResponseMessage(String toUserName, String fromUserName,
			String accountId) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.accountId = accountId;
	}

	/**
	 * 构造方法
	 * 
	 * @param requestMessage
	 */
	public ResponseMessage(RequestMessage requestMessage) {
		this.toUserName = requestMessage.getFromUserName();
		this.fromUserName = requestMessage.getToUserName();
		this.msgId = requestMessage.getMsgId();
		this.msgType = requestMessage.getMsgType();
		this.accountId = requestMessage.getAccountId();
	}

	/**
	 * 获取属性：表示流程是否处理结束
	 * 
	 * @return
	 */
	public boolean isEndFlag() {
		return endFlag;
	}

	/**
	 * 设置属性：表示流程是否处理结束
	 * 
	 * @param endFlag
	 */
	public void setEndFlag(boolean endFlag) {
		this.endFlag = endFlag;
	}

	/**
	 * 获取消息渠道
	 */
	@Override
	protected int getUserSend() {
		return 0;
	}

	/**
	 * 转换为xml字符串
	 */
	@Override
	public final String toString() {
		StringBuilder out = new StringBuilder();
		out.append("\n<xml>\n");
		out.append("	<ToUserName><![CDATA[").append(this.toUserName).append("]]></ToUserName>\n");
		out.append("	<FromUserName><![CDATA[").append(this.fromUserName).append("]]></FromUserName>\n");
		out.append("	<MsgType><![CDATA[").append(this.getMsgType()).append("]]></MsgType>\n");
		out.append("	<CreateTime><![CDATA[").append(getCreateTime()).append("]]></CreateTime>\n");
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

}
