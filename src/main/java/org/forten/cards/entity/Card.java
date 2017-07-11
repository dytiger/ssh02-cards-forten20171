package org.forten.cards.entity;

import org.forten.cards.entity.enums.CardStatus;
import org.forten.cards.entity.enums.CardType;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/11.
 */
@Entity
@Table(name="cards")
public class Card {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    @Enumerated(EnumType.STRING)
    private CardType type;
    @Column
    private int times;
    @Column
    private double discount;
    @Column
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @Column(name="create_time")
    private Date createTime;

    public Card() {
        this.status = CardStatus.SU;
        this.createTime = new Date();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price < 50 ? 50 : price;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public void setTimes(int times) {
        this.times = times < 0 ? 0 : times;
    }

    public void setDiscount(double discount) {
        this.discount = (discount <= 0 || discount > 1) ? 1.0 : discount;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public CardType getType() {
        return type;
    }

    public int getTimes() {
        return times;
    }

    public double getDiscount() {
        return discount;
    }

    public CardStatus getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return id == card.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Card{" +
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
