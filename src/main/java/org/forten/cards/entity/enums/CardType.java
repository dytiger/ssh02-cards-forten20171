package org.forten.cards.entity.enums;

/**
 * Created by Administrator on 2017/7/11.
 */
public enum CardType {
    TI("计次卡"),DC("折扣卡");

    private String des;

    CardType(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public String getName(){
        return this.name();
    }
}
