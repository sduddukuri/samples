package org.sample.web.jms;
// http://spring.io/guides/gs/messaging-jms/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/jms")
public class JMSMessagegController {
	public static final String SUCCESS_RESPONSE="Message send to broaker successfully!";
	
	@Autowired @Qualifier("messageProducer") JmsMessageProducer producer;

	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String sendJmsMessage(@RequestParam(required=true) String message, @RequestParam String destinationName){
		producer.sendMessage(destinationName, message);
		return SUCCESS_RESPONSE;
	}

	public void setProducer(JmsMessageProducer producer) {
		this.producer = producer;
	}
	
	
}
