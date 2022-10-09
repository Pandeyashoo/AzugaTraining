package training.azuga.com;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sendmail{
    public static void main(String[] args) {
        String[] to = {"pruthvikumar.p24@gmail.com","krupa@codeops.tech","sudharshan@codeops.tech","indukurimr@azuga.com","adarshs@azuga.com","aparajitam@azuga.com","ashoop@azuga.com",
                "dushyants@azuga.com","kartiks@azuga.com","lokanathk@azuga.com","pruthvikp@azuga.com","rajatt@azuga.com",
                "rishabh@azuga.com","satvikm@azuga.com","suryaps@azuga.com","vijayyv@azuga.com"};

        String from = "ashoop@azuga.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props);
        for(String toall: to) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(toall));
                message.setSubject("System Generated Reports / 30 Sept 2022");
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText("This message contains Reports zip file for converter program." + '\n' + "This is a system generated Mail.Do not reply. " + '\n' + "Thanks");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                messageBodyPart = new MimeBodyPart();
                String filename = "/Users/azuga/Desktop/con.zip";
                DataSource source = new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(filename);
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
                Transport.send(message, "ashoop@azuga.com", "zhlwzivjgnhiounj");

                System.out.println("Sent message successfully....");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}