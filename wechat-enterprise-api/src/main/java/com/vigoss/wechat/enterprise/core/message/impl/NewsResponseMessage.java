package com.vigoss.wechat.enterprise.core.message.impl;

import java.util.List;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;
import com.vigoss.wechat.enterprise.core.pojo.NewsItem;
import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;
import com.vigoss.wechat.enterprise.core.pojo.NewsItem;

/**
 * 多图文类型响应消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class NewsResponseMessage extends ResponseMessage {

	/**
	 * 构造方法
	 * @param toUserName
	 * @param fromUserName
	 * @param accountId
	 */
	public NewsResponseMessage(String toUserName,String fromUserName,String accountId){
		super(toUserName, fromUserName, accountId);
	}
	
	/**
	 * 构造方法
	 * @param rm
	 */
	public NewsResponseMessage(RequestMessage requestMessage) {
		super(requestMessage);
	}

	/**
	 * 获取响应消息类型
	 */
	@Override
	public String getMsgType() {
		return "news";
	}

	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	public void toString(StringBuilder out) {
		List<Object> data=getData();
		out.append("  <ArticleCount>").append(data.size()).append("</ArticleCount>\n");
		out.append("  <Articles>\n");
		for(Object obj:data){
			NewsItem item=(NewsItem)obj;
			out.append("  <item>\n");
			out.append("    <Title><![CDATA[").append(item.getTitle()).append("]]></Title>\n");
			out.append("    <Description><![CDATA[").append(item.getDescription()).append("]]></Description>\n");
			out.append("    <PicUrl><![CDATA[").append(item.getPicurl()).append("]]></PicUrl>\n");
			out.append("    <Url><![CDATA[").append(item.getUrl()).append("]]></Url>\n");
			out.append("  </item>\n");
		}
		out.append("  </Articles>\n");
	}

}
