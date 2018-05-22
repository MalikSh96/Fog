package presentationlayer;


import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.ws.wsdl.writer.document.Message;
import dbaccess.UserMapper;
import functionlayer.LoginSampleException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeJava.to;
import static presentationlayer.Command.from;
import sun.rmi.transport.Transport;

public class NewsLetter extends Command {

    UserMapper um = new UserMapper();
    
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
    
        
        
        HttpSession session = request.getSession();
        session.getAttribute("file");
        
        List<String> emails = um.newsletterEmails();
        
        
      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
        
        return "help";    
    }
    
}

