package pl.coderslab.SalonManager.notification;

public interface EmailSender {

    void send(String to, String subject, String message);
    void contactUs(String name, String from, String message);
}
