package org.forten.cards.dto.ro;

/**
 * Created by Administrator on 2017/7/10.
 */
public enum MessageType {
    INFO("消息"),WARN("警告"),ERROR("错误"),DATA_ERROR("数据错误");

    private int code;
    private String des;

    MessageType(String des) {
        this.code = this.ordinal();
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getLevel(){
        return this.name();
    }

    public String getDes() {
        return des;
    }
}
