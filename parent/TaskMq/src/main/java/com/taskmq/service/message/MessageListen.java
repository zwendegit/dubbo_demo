package com.taskmq.service.message;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.stereotype.Component;

import com.taskmq.bean.user.DrMember;
@Component
public class MessageListen implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		 System.out.println("监听==================监听");
	        try {
	        	ActiveMQDestination queues=(ActiveMQDestination)arg0.getJMSDestination(); 
	        	if(queues.getPhysicalName().equals("queue1")){//文本消息
	        		if(arg0 instanceof TextMessage){
	        			 TextMessage tm = (TextMessage) arg0;
	 	 	            System.out.println("监听到队列名为：<font color='red'>"+queues.getPhysicalName()+"</font>的数据。。。。"+tm.getText());
	        		}else if(arg0 instanceof MapMessage){//map消息
	        			MapMessage mm=(MapMessage) arg0;
	        			System.out.println("监听到队列名为：<font color='red'>"+queues.getPhysicalName()+"</font>的数据。。。。"+mm.getString("text"));
	        		}else if(arg0 instanceof ObjectMessage){//对象消息
	        			ObjectMessage om=(ObjectMessage) arg0;
	        			DrMember user=(DrMember) om;
	        			System.out.println("监听到队列名为：<font color='red'>"+queues.getPhysicalName()+"</font>的数据。。。。"+user.getMobilephone());
	        		}else if(arg0 instanceof BytesMessage){//byte 消息
	        			byte[] b = new byte[1024];  
	                    int len = -1;  
	                    BytesMessage bm = (BytesMessage) arg0;  
	                    try {  
	                        while ((len = bm.readBytes(b)) != -1) {  
	                            System.out.println(new String(b, 0, len));  
	                        }  
	                    } catch (JMSException e) {  
	                        // TODO Auto-generated catch block  
	                        e.printStackTrace();  
	                    }
	        		}else if(arg0 instanceof StreamMessage){//stream 消息
	        			StreamMessage sm=(StreamMessage) arg0;
	        			System.out.println(sm.readString());  
	        		}
	        		
	        	}else if(queues.getPhysicalName().equals("queue2")){
	        		if(arg0 instanceof TextMessage){
	        			 TextMessage tm = (TextMessage) arg0;
	 	 	            System.out.println("监听到队列名为：<font color='red'>"+queues.getPhysicalName()+"</font>的数据。。。。"+tm.getText());
	        		}else if(arg0 instanceof MapMessage){//map消息
	        			MapMessage mm=(MapMessage) arg0;
	        			System.out.println("监听到队列名为：<font color='red'>"+queues.getPhysicalName()+"</font>的数据。。。。"+mm.getString("text"));
	        		}else if(arg0 instanceof ObjectMessage){//对象消息
	        			ObjectMessage om=(ObjectMessage) arg0;
	        			DrMember user=(DrMember) om;
	        			System.out.println("监听到队列名为：<font color='red'>"+queues.getPhysicalName()+"</font>的数据。。。。"+user.getMobilephone());
	        		}else if(arg0 instanceof BytesMessage){//byte 消息
	        			byte[] b = new byte[1024];  
	                    int len = -1;  
	                    BytesMessage bm = (BytesMessage) arg0;  
	                    try {  
	                        while ((len = bm.readBytes(b)) != -1) {  
	                            System.out.println(new String(b, 0, len));  
	                        }  
	                    } catch (JMSException e) {  
	                        // TODO Auto-generated catch block  
	                        e.printStackTrace();  
	                    }
	        		}else if(arg0 instanceof StreamMessage){//stream 消息
	        			StreamMessage sm=(StreamMessage) arg0;
	        			System.out.println(sm.readString());  
	        		}
	        	}
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	}

}
