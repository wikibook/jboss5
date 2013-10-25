package com.jbossnotebook.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

@MessageDriven(activationConfig =
{
	@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
	@ActivationConfigProperty(propertyName="destination", propertyValue="queue/exampleQueue")
})

public class MessageConsumer implements MessageListener {

	public void onMessage(Message msg) {
		
		TextMessage text = (TextMessage)msg;
		
		try {
			System.out.println("Received Message is " + text.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
