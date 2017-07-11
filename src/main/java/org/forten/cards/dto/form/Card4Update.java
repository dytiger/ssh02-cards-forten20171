package org.forten.cards.dto.form;

import org.forten.cards.entity.enums.CardStatus;
import org.forten.cards.entity.enums.CardType;
import org.forten.utils.common.EnumUtil;
import org.forten.utils.system.ValidateException;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017/7/11.
 */
public class Card4Update {
    private int id;
    @NotBlank(message = "请输入优惠卡名称")
    private String name;
    @Min(value = 50, message = "优惠卡最小金额为{value}")
    private double price;
    private CardType type;
    private int times;
    private double discount;

    public Card4Update() {
    }

    public Card4Update(int id, String name, double price, CardType type, int times, double discount) {
        setId(id);
        setName(name);
        setPrice(price);
        setType(type);
        setTimes(times);
        setDiscount(discount);
        valid();
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

    public void setTypeName(String typeName){
        this.type = EnumUtil.getEnumByName(CardType.class,typeName);
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times < 0 ? 0 : times;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = (discount <= 0 || discount > 1) ? 1.0 : discount;
    }

    public void valid(){
        if (times == 0 && discount == 1) {
            throw new ValidateException("请设置优惠卡的计次数量或折扣 [" + this.toString() + "]");
        }
    }

    @Override
    public String toString() {
        return "Card4Update{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", times=" + times +
                ", discount=" + discount +
                '}';
    }
}
