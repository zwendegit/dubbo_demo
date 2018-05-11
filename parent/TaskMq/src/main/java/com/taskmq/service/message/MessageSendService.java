package com.taskmq.service.message;

import javax.jms.Destination;

public interface MessageSendService {

	/**
	 * 发送文本消息
	 * @param text
	 */
	void sendMessageText(String text);
	/**
	 * 像指定队列发送消息
	 * @param queueName 队列名
	 * @param text 消息内容
	 */
	void sendMessage(String queueName ,Object text);
}
