package au.edu.sydney.Curracurrong.runtime;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import au.edu.sydney.Curracurrong.datatype.DRecord;
import au.edu.sydney.Curracurrong.datatype.Data;
import au.edu.sydney.Curracurrong.datatype.ParsingException;

public class EMailSink extends Sink {
	
	private String sendTo;
	
	void initialize(int opID, Hashtable propertyMap) {
        // call constructor of super-class to initialize
        // channels
        super.initialize(opID, propertyMap);
		if (propertyMap.containsKey("email")) {
			DRecord property = (DRecord) propertyMap.get("email");
			try {
				sendTo = property.getElement(1).tostring();
			} catch (ParsingException e) {
				e.printStackTrace();
				System.out.println("Unable to parse property \"file\"");
			}
		}
	}

	@Override
	public void write(Data d) {
		DRecord rec = (DRecord) d;
		String content = rec.tostring();
		sendEmail(content, "Warning: Usage Reached Threshold");
	}
	
	public void sendEmail(String content, String subject) {
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "127.0.0.1");
			
			Session mailSession = Session.getDefaultInstance(props, null);
			Transport transport = mailSession.getTransport();
			MimeMessage message = new MimeMessage(mailSession);
			InternetAddress addressFrom = new InternetAddress(
					"curracurrong-alert@gmail.com");
			message.setFrom(addressFrom);
			message.setSubject(subject);
			message.setContent(content,"text/html");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					sendTo));			
			
			transport.connect();
			transport.sendMessage(message,
					message.getRecipients(Message.RecipientType.TO));
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}