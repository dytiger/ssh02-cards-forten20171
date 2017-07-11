package org.forten.cards.dto.form;

import org.forten.cards.entity.enums.CardType;
import org.forten.utils.common.EnumUtil;
import org.forten.utils.system.ValidateException;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/11.
 */
public class Card4Save {
    @NotBlank(message = "请输入优惠卡名称")
    protected String name;
    @Min(value = 50, message = "优惠卡最小金额为{value}")
    protected double price;
    protected String typeName;
    protected int times;
    protected double discount;

    public Card4Save() {
    }

    public Card4Save(String name, double price, String  typeName, int times, double discount) {
        setName(name);
        setPrice(price);
        setTypeName(typeName);
        setTimes(times);
        setDiscount(discount);
        valid();
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public CardType getType() {
        return EnumUtil.getEnumByName(CardType.class,typeName);
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
        return "Card4Save{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", typeName='" + typeName + '\'' +
                ", times=" + times +
                ", discount=" + discount +
                '}';
    }
}
