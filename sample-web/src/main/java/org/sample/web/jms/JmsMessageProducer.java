package org.sample.web.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageProducer {
	
	protected JmsTemplate template;
	
	// JMS Messages are send to default queue unless supplied. 
	public void sendMessage(String destinationName, String message){
		if(destinationName==null || destinationName.equals("")){
			template.send(createMessage(message));
		}else{
			template.convertAndSend(destinationName, message);
		}
	}

	private MessageCreator createMessage(final String message) {
		
		return new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				return session.createTextMessage(message);
			}
		};
	}


	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}
	
	
}
