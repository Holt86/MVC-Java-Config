package ru.mvc.models;

/**
 * Created by User on 23.01.2019.
 */
public class Message {
    private String to;
    private String message;

    public Message(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
