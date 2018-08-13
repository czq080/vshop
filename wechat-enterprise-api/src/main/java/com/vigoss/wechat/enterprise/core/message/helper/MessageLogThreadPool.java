package com.vigoss.wechat.enterprise.core.message.helper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.vigoss.wechat.enterprise.core.pojo.ChatMsg;
import com.vigoss.wechat.enterprise.core.pojo.NewsItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vigoss.wechat.enterprise.core.pojo.ChatMsg;
import com.vigoss.wechat.enterprise.core.pojo.NewsItem;

public class MessageLogThreadPool {

	private static Logger logger = LoggerFactory.getLogger(MessageLogThreadPool.class);

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(50);// 开100个线程
	}

	public static void destroy() {
		pool.shutdown();
	}

	/**
	 * 新增消息日志处理线程并执行线程
	 * 
	 * @param list
	 */
	public static void saveMessage(List<ChatMsg> msglist) {
		logger.info("保存发送和接受信息");
		pool.execute(new MessageLogThread(msglist));
	}
}

/**
 * 消息日志处理线程类
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
class MessageLogThread extends Thread {

	private List<ChatMsg> msglist;

	public MessageLogThread(List<ChatMsg> msglist) {
		super();
		this.msglist = msglist;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);

//			MessageLogService messageLogService = (MessageLogService) DatabaseHelper.getBean(MessageLogService.class);
			if (null != msglist && msglist.size() > 0) {
				for (ChatMsg msg : msglist) {
//					messageLogService.saveMessage(msg);
					List<NewsItem> newsList = msg.getNewsList();
					if (null != newsList && newsList.size() > 0) {
						for (NewsItem item : newsList) {
//							messageLogService.saveNewsItem(item);
						}
					}
				}
			}
		} catch (InterruptedException e) {

		}

	}

}
