package org.forten.cards.dto.vo;

import org.forten.cards.entity.enums.CardStatus;
import org.forten.cards.entity.enums.CardType;
import org.forten.utils.common.DateUtil;

import java.text.NumberFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/11.
 */
public class Card4Show {
    private int id;
    private String name;
    private double price;
    private CardType type;
    private int times;
    private double discount;
    private CardStatus status;
    private Date createTime;

    public Card4Show() {
    }

    public Card4Show(int id, String name, double price, CardType type, int times, double discount, CardStatus status, Date createTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.times = times;
        this.discount = discount;
        this.status = status;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeName() {
        return type.getDes();
    }

    public String getStatusName() {
        return status.getDes();
    }

    public String getCreateTimeStr() {
        return createTime == null ? "" : DateUtil.convertDateToString(createTime, "yyyy年MM月dd日 HH:mm");
    }

    public String getTimesStr() {
        return type.ordinal() == 0 ? "" + times : "-";
    }

    public String getDiscountStr() {
        return type.ordinal() == 1 ? "" + discount : "-";
    }

    @Override
    public String toString() {
        return "Card4Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", times=" + times +
                ", discount=" + discount +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
