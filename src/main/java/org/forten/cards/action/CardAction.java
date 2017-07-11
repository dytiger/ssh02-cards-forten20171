package org.forten.cards.action;

import org.forten.cards.bo.CardBo;
import org.forten.cards.dto.form.Card4Save;
import org.forten.cards.dto.qo.CardQo;
import org.forten.cards.dto.ro.Message;
import org.forten.cards.dto.ro.RoWithPage;
import org.forten.cards.dto.vo.Card4Show;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/11.
 */
@Controller
public class CardAction {
    @Resource
    private CardBo bo;

    @RequestMapping("/card/save.do")
    public @ResponseBody Message save(@RequestBody Card4Save dto){
        Message m = bo.doSave(dto);
        return m;
    }

    @RequestMapping("/card/list.do")
    public @ResponseBody
    RoWithPage<Card4Show> list(@RequestBody CardQo qo){
        return bo.queryBy(qo);
    }
}
