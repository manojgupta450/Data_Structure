package com.eviac.blog.jms;

import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.BasicConfigurator;
public class Producer {
 public Producer() throws JMSException, NamingException {
  // Obtain a JNDI connection
	 
	 Properties props = new Properties();
	 props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	 props.setProperty(Context.PROVIDER_URL,"tcp://localhost:8161");
	 //InitialContext ctx = new InitialContext(props);
  InitialContext jndi = new InitialContext(props);
  // Look up a JMS connection factory
 /* ConnectionFactory conFactory = (ConnectionFactory) jndi
    .lookup("connectionFactory");*/
  
  
  QueueConnectionFactory connFactory = (QueueConnectionFactory) jndi.lookup("ConnectionFactory");        
//create a queue connection
QueueConnection connection = connFactory.createQueueConnection();   
connection.start();
//lookup the queue object
  try {
   connection.start();
   // JMS messages are sent and received using a Session. We will
   // create here a non-transactional session object. If you want
   // to use transactions you should set the first parameter to 'true'
   Session session = connection.createSession(false,
     Session.AUTO_ACKNOWLEDGE);
   Destination destination = (Destination) jndi.lookup("jms/MyQueue");
   // MessageProducer is used for sending messages (as opposed
   // to MessageConsumer which is used for receiving them)
   MessageProducer producer = session.createProducer(destination);
   // We will send a small text message saying 'Hello World!'
   TextMessage message = session.createTextMessage("Hello World!");
   // Here we are sending the message!
   producer.send(message);
   System.out.println("Sent message '" + message.getText() + "'");
  } finally {
   connection.close();
  }
 }
 public static void main(String[] args) throws JMSException {
  try {
   BasicConfigurator.configure();
   new Producer();
  } catch (NamingException e) {
   e.printStackTrace();
  }
 }
}