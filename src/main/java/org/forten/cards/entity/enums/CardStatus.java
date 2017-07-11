package org.forten.cards.entity.enums;

/**
 * Created by Administrator on 2017/7/11.
 */
public enum CardStatus {
    SU("销售中"),BU("停售");

    private String des;

    CardStatus(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public String getName(){
        return this.name();
    }
}
