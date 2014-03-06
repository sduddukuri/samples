package org.sample.web.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JMSMessageConsumer implements MessageListener{
	
	protected JmsTemplate template;
	

	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage){
			String messageText = null ;
			
			try {
				 messageText = ((TextMessage)message).getText();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Received text message:" + messageText );
			
		}
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}
	
}
