package org.forten.cards.bo;

import org.forten.cards.dto.form.Card4Save;
import org.forten.cards.dto.form.Card4Update;
import org.forten.cards.dto.qo.CardQo;
import org.forten.cards.dto.ro.Message;
import org.forten.cards.dto.ro.RoWithPage;
import org.forten.cards.dto.vo.Card4Show;
import org.forten.cards.entity.Card;
import org.forten.cards.entity.enums.CardStatus;
import org.forten.cards.entity.enums.CardType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring/app-*.xml")
public class CardBoTest {
    @Resource
    private CardBo bo;

    @Test
    public void testDoSave(){
        Card4Save card = new Card4Save();
        card.setName("Test");
        card.setPrice(10000);
        card.setTypeName("DC");
        card.setDiscount(0.5);
        card.setTimes(0);

        Message m = bo.doSave(card);

        Assert.assertEquals(0,m.getCode());
    }

    @Test
    public void testDoSaveWithBlankName(){
        Card4Save card = new Card4Save();
        card.setName("");
        card.setPrice(10000);
        card.setTypeName("DC");
        card.setDiscount(0.5);
        card.setTimes(0);

        Message m = bo.doSave(card);

        Assert.assertEquals(3,m.getCode());
        m.getMessageList().forEach(System.out::println);
    }

    @Test
    public void testDoSaveWithBlankNameAndInvalidPrice(){
        Card4Save card = new Card4Save();
        card.setName("");
        card.setPrice(-50);
        card.setTypeName("DC");
        card.setDiscount(0.5);
        card.setTimes(0);

        Message m = bo.doSave(card);

        Assert.assertEquals(3,m.getCode());
        m.getMessageList().forEach(System.out::println);
    }

    @Test
    public void testDoSaveWithInvalidTimesAndDiscount(){
        Card4Save card = new Card4Save();
        card.setName("Test");
        card.setPrice(1000);
        card.setTypeName("DC");
        card.setDiscount(0.0);
        card.setTimes(0);

        Message m = bo.doSave(card);

        Assert.assertEquals(1.0,card.getDiscount(),0);
        Assert.assertEquals(0,card.getTimes());
        Assert.assertEquals(3,m.getCode());
        m.getMessageList().forEach(System.out::println);
    }

    @Test
    public void testQueryBy(){
        CardQo qo = new CardQo();
        RoWithPage<Card4Show> ro = bo.queryBy(qo);

        Assert.assertEquals(2,ro.getDataListSize());
        Assert.assertEquals(5,ro.getPage().getTotalPage());
        ro.getDataList().forEach(System.out::println);

        qo.setPageSize(10);
        qo.setTypeName("TI");
        ro = bo.queryBy(qo);

        Assert.assertEquals(5,ro.getDataListSize());
        ro.getDataList().forEach(System.out::println);

        qo.setPageSize(10);
        qo.setTypeName(null);
        qo.setStatusName("BU");
        ro = bo.queryBy(qo);

        Assert.assertEquals(4,ro.getDataListSize());
        ro.getDataList().forEach(System.out::println);
    }

    @Test
    public void testDoUpdate(){
        Card4Update dto = new Card4Update(1,"霸王折扣卡",1000,CardType.DC,0,0.3);
        Message m = bo.doUpdate(dto);

        Assert.assertEquals(0,m.getCode());
    }
}
