package pl.coderslab.SalonManager.notification;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public void send(String to, String subject, String message) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

            mimeMessageHelper.setText(message, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom("no-reply@salonManager.com");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            LOGGER.error("Failed to send email", ex);
            throw new IllegalStateException("Failed to send email");
        }
    }

    @Override
    public void contactUs(String name, String from, String message) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

            mimeMessageHelper.setText(message);
            mimeMessageHelper.setTo("salonManager@salonManager.com");
            mimeMessageHelper.setFrom(from);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            LOGGER.error("Failed to send email", ex);
            throw new IllegalStateException("Failed to send email");
        }
    }
}
