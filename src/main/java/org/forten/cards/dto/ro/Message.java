package org.forten.cards.dto.ro;

import static org.forten.cards.dto.ro.MessageType.INFO;
import static org.forten.cards.dto.ro.MessageType.WARN;
import static org.forten.cards.dto.ro.MessageType.ERROR;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Message {
    private String message;
    private MessageType type;

    private Message(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }

    public static Message info(String message){
        return new Message(message,INFO);
    }
    public static Message warn(String message){
        return new Message(message,WARN);
    }
    public static Message error(String message){
        return new Message(message,ERROR);
    }

    public String getMessage() {
        return message;
    }

    public int getMessageTypeCode(){
        return type.getCode();
    }

    public String getMessageTypeDes(){
        return type.getDes();
    }

    public MessageType getType() {
        return type;
    }
}
