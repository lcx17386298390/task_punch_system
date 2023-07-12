package com.acm.msgtomail.Service;

import com.acm.msgtomail.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
@Component
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    //发送简单邮件
    public void sendSimpleMail(Mail mail) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom(mail.getFrom());//发送者
        smm.setTo(mail.getSendTo());//收件人
        smm.setCc(mail.getCc());//抄送人
        smm.setSubject(mail.getSubject());//邮件主题
        smm.setText(mail.getText());//邮件内容
        javaMailSender.send(smm);//发送邮件
    }


    public void sendMailWithFile(Mail mail) {
        try {
            MimeMessage mm = javaMailSender.createMimeMessage();
            MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
            mmh.setFrom(mail.getFrom());
            mmh.setTo(mail.getSendTo());
            mmh.setCc(mail.getCc());
            mmh.setSubject(mail.getSubject());
            mmh.setText(mail.getText());
            //添加附件
          // mmh.addAttachment(mm.getFileName(), mail.getName(),);
            javaMailSender.send(mm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
