/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail;

import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.swing.JOptionPane;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
/**
 *
 * @author laura
 */
public class JCMail {

    private String from = "qpqsoporte@gmail.com";
    private String password = "qpqs0p0rt3"; 
    private InternetAddress[] addressTo;
    private String Subject = "";//titulo del mensaje
    private String MessageMail = "";//contenido del mensaje

    public JCMail(){}

    public void SEND()
    {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.user", "usuario");
            props.put("mail.smtp.port", 25);
            //
            SMTPAutentificacion auth = new SMTPAutentificacion( getFrom(), getPassword() );
            Session session = Session.getDefaultInstance(props, auth);
            session.setDebug(false);
            //Se crea destino y origen del mensaje
            MimeMessage mimemessage = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress( getFrom() );
            mimemessage.setFrom(addressFrom);
            mimemessage.setRecipients(Message.RecipientType.TO, addressTo);
            mimemessage.setSubject( getSubject() );
            // Se crea el contenido del mensaje
            MimeBodyPart mimebodypart = new MimeBodyPart();
            mimebodypart.setText( getMessage() );
            mimebodypart.setContent( getMessage() , "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimebodypart);            
            mimemessage.setContent(multipart);            
            mimemessage.setSentDate(new Date());
            Transport.send(mimemessage);
            JOptionPane.showMessageDialog(null, "Correo enviado. Enjoy!!!");
        } catch (MessagingException ex) {
            System.out.println(ex);
        }

    }
    //remitente
    public void setFrom(String mail){ this.from = mail; }
    public String getFrom(){ return this.from; }
    //Contraseña
    public void setPassword(char[] value){
        this.password = new String(value);
    }
    public String getPassword(){ return this.password; }
    //destinatarios
    public void setTo(String mails){
        String[] tmp =mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public InternetAddress[] getTo(){ return this.addressTo; }
    //titulo correo
    public void setSubject(String value){ this.Subject = value; }
    public String getSubject(){ return this.Subject; }
    //contenido del mensaje
    public void setMessage(String value){ this.MessageMail = value; }
    public String getMessage(){ return this.MessageMail; }
    
}



