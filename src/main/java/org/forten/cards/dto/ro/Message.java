package org.forten.cards.dto.ro;

import java.util.Arrays;
import java.util.List;

import static org.forten.cards.dto.ro.MessageType.INFO;
import static org.forten.cards.dto.ro.MessageType.WARN;
import static org.forten.cards.dto.ro.MessageType.ERROR;
import static org.forten.cards.dto.ro.MessageType.DATA_ERROR;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Message {
    private String message;
    private MessageType type;
    private List<String> messageList;

    private Message(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }

    private Message(MessageType type, String... msgs) {
        this.messageList = Arrays.asList(msgs);
        this.type = type;
    }

    public static Message info(String message) {
        return new Message(message, INFO);
    }

    public static Message warn(String message) {
        return new Message(message, WARN);
    }

    public static Message error(String message) {
        return new Message(message, ERROR);
    }

    public static Message dataError(String... msgs) {
        return new Message(DATA_ERROR, msgs);
    }

    public String getMessage() {
        return message;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public int getCode() {
        return type.getCode();
    }

    public String getLevel() {
        return type.name();
    }

    public String getTypeDes() {
        return type.getDes();
    }

    public MessageType getType() {
        return type;
    }
}
