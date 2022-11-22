import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {

    public static void naverMailSend() {
        final String host = "smtp.naver.com";
        final String port = "587";
        final String user = "ys010610@naver.com";
        final String password = "Rpdlqk@1004";

        System.out.println("Properties 전");
        // SMTP 서버 정보를 설정한다.
        Properties props = new Properties();              //System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.auth", "true");

        System.out.println("Properties 후");

        System.out.println("Session 선언 전");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        System.out.println("Session 선언 후");

        try {
            System.out.println("MimeMessage 선언 전");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("gipsy674@gmail.com"));

            System.out.println("MimeMessage 선언 후");

            // 메일 제목
            message.setSubject("KTKO SMTP TEST1111");

            // 메일 내용
            message.setText("KTKO Success!!");

            System.out.println("Transport 전");

            // send the message
            javax.mail.Transport.send(message);
            System.out.println("Success Message Send");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
        naverMailSend();
    }
}
