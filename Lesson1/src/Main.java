import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
//        sendMailWithFile();
//        base64Example();
//        sendMailWithMailtrap();
//        test(getEncodedString());
        System.out.println(getEncodedString());
    }

    public static void sendMailWithFile() {

        // Recipient's email ID needs to be mentioned.
        String to = "jamolbek2609@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "davalisher@gmail.com";

        final String username = "davalisher";//change accordingly
        final String password = "eqwyipiydybzyszr";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("This is message body");


            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            BodyPart fileBodyPart = new MimeBodyPart();
            String filename = "resources/rasm.jpg";
            DataSource source = new FileDataSource(filename);
            fileBodyPart.setDataHandler(new DataHandler(source));
            fileBodyPart.setFileName("hello");
            multipart.addBodyPart(fileBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void base64Example() throws IOException {
        String encodedMessage = getEncodedString();
//        System.out.println(encodedMessage);
//        String decodedMessage=new String(decoder.decode(encodedMessage));
//        System.out.println(decodedMessage);
        String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                <audio controls>
                    <source src="data:audio/mp3;base64, %s" type="audio/mp3">
                    Your browser does not support the audio tag.
                </audio>
                </body>
                </html>
                """.formatted(encodedMessage);
        Path htmlFile = Path.of("resources/html_file.html");
        Files.write(htmlFile, html.getBytes());

    }

    private static String getEncodedString() throws IOException {
        Base64.Encoder encoder = Base64.getMimeEncoder();
//        Base64.Decoder decoder = Base64.getMimeDecoder();
//        String message="Hello";
        Path path = Path.of("resources/rasm.jpg");
        String encodedMessage = encoder.encodeToString(Files.readAllBytes(path));
        return encodedMessage;
    }

    public static void sendMailWithMailtrap() {


        // Recipient's email ID needs to be mentioned.
        String to = "davalisher@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "davalisher@gmail.com";

        final String username = "f665fe74b4b064";//change accordingly
        final String password = "53978b539ea435";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "sandbox.smtp.mailtrap.io";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Create the message part
            message.setContent("<h1 style=\"color:red;\">Body of mail here</h1>", "text/html");
            BodyPart bodyPart = new MimeBodyPart();
            String body = """
                    <div>
                    <h1 style="color:red;">Body of mail here</h1>
                    <img src="data:rasm/jpg;base64,%s" width=100 >
                    </div>
                    """.formatted(getEncodedString());
            bodyPart.setContent(body, "text/html");
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);


            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void test(String encodedText) throws IOException {
        Path htmlFile = Path.of("resources/copy_rasm.jpg");
        Base64.Decoder decoder=Base64.getDecoder();
        Files.write(htmlFile, decoder.decode(encodedText.getBytes()));
    }

}