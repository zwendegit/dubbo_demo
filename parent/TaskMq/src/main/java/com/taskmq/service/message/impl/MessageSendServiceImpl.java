package com.taskmq.service.message.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.taskmq.service.message.MessageSendService;
@Service("sendMessageService")
public class MessageSendServiceImpl implements MessageSendService{

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination destination;
	@Override
	public void sendMessageText(final String text) {
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage msg = arg0.createTextMessage();
                msg.setText("发送数据++++++++++++"+text);
                return msg;
			}
		});
		
	}
	@Override
	public void sendMessage(String queueName,final Object text) {
		if(StringUtils.isEmpty(queueName)){
			destination=jmsTemplate.getDefaultDestination();
		}else{
////			ActiveMQDestination activeMQDestination=(ActiveMQDestination) destination;
//			if(queueName.equals("queue1")){
////				destination=activeMQDestination.getCompositeDestinations()[0];
//			}else{//queue2
////				destination=activeMQDestination.getCompositeDestinations()[1];
//				
//			}
			destination=new ActiveMQQueue(queueName);
		}
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage msg = arg0.createTextMessage();
                msg.setText("发送数据++++++++++++"+text);
				return msg;
			}
		});
	}

}
