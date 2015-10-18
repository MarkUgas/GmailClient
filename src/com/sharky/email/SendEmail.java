/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharky.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sharmarke
 */
public class SendEmail {

    private String user = "sharmarke.ugas@gmail.com";
    private String pass = "please28";
    
    public SendEmail(String to, String subject, String msg) {
        
        Properties prop = new Properties();
        prop.put("mail.smpt.ssl.trust","smtp.gmail.com");
        prop.put("mail.smpt.suth",true);
        prop.put("mail.smpt.starttls.enable",true);
        prop.put("mail.smpt.host","smtp.gmail.com");
        prop.put("mail.smpt.port","587");
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator()
                {
                  protected javax.mail.PasswordAuthentication getPasswordAuthentication()
                  {
                   return new javax.mail.PasswordAuthentication(user, pass);
                  }
                });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));  
            String sub = null;
            message.setSubject(sub);
            message.setText(msg);
            
            Transport.send(message);
            
            System.out.println("Mail Sent");
            
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    
}
