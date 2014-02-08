/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author laura
 */
public class SMTPAutentificacion extends Authenticator{
    
    private String SMTP_AUTH_USER = "";
    private String SMTP_AUTH_PWD = "";

    public SMTPAutentificacion() {}

    public SMTPAutentificacion(String user , String pass) {
        this.SMTP_AUTH_USER = user;
        this.SMTP_AUTH_PWD = pass;
    }

 @Override
public PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(this.SMTP_AUTH_USER, this.SMTP_AUTH_PWD);
}
}
