package org.forten.cards.bo;

import org.apache.log4j.Logger;
import org.forten.cards.dto.form.Card4Save;
import org.forten.cards.dto.form.Card4Update;
import org.forten.cards.dto.qo.CardQo;
import org.forten.cards.dto.ro.Message;
import org.forten.cards.dto.ro.RoWithPage;
import org.forten.cards.dto.vo.Card4Show;
import org.forten.cards.entity.Card;
import org.forten.cards.entity.enums.CardStatus;
import org.forten.cards.entity.enums.CardType;
import org.forten.dao.HibernateDao;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.PageInfo;
import org.forten.utils.system.ValidateException;
import org.forten.utils.system.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@Service("cardBo")
public class CardBo {
    private static final Logger log = Logger.getLogger(CardBo.class);

    @Resource
    private HibernateDao dao;

    @Transactional
    public Message doSave(Card4Save dto) {
        try {
            ValidateUtil.validateThrow(dto);
            dto.valid();
            Card card = new Card();
            BeanPropertyUtil.copy(card, dto);
            dao.save(card);
            log.debug("保存成功：[" + card.toString() + "]");
            return Message.info("保存成功");
        } catch (ValidateException e) {
            if (log.isDebugEnabled()) {
                e.printStackTrace();
            }
            log.error("优惠卡数据格式错误", e);
            return Message.dataError(e.getMessages().toArray(new String[]{}));
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                e.printStackTrace();
            }
            log.error("卡信息保存失败", e);
            return Message.error("保存失败");
        }
    }

    @Transactional(readOnly = true)
    public RoWithPage<Card4Show> queryBy(CardQo qo) {
        String countHql = "SELECT count(id) FROM Card WHERE 1=1 ";
        String hql = "SELECT new org.forten.cards.dto.vo.Card4Show(id,name,price,type,times,discount,status,createTime) " +
                "FROM Card WHERE 1=1 ";
        Map<String, Object> params = new HashMap<>();

        CardType type = qo.getType();
        CardStatus status = qo.getStatus();
        if (type != null) {
            countHql = countHql + "AND type=:type ";
            hql = hql + "AND type=:type ";
            params.put("type", type);
        }
        if (status != null) {
            countHql = countHql + "AND status=:status ";
            hql = hql + "AND status=:status ";
            params.put("status", status);
        }

        log.debug("统计符合条件数据总量的HQL语句：[" + countHql + "]");
        long count = dao.findOneBy(countHql, params);
        if (count == 0) {
            return RoWithPage.EMPTY_RO;
        }

        PageInfo page = PageInfo.getInstance(qo.getPageNo(), qo.getPageSize(), count);

        hql = hql + "ORDER BY " + qo.getOrderField() + " " + qo.getOrderType();

        log.debug("查询语句：[" + hql + "]");
        List<Card4Show> dtoList = dao.findBy(hql, params, (int) page.getFirstResultNum(), page.getPageSize());

        return new RoWithPage<>(dtoList, page);
    }

    @Transactional
    public Message doUpdate(Card4Update dto) {
        // TODO 应该校验此卡是否已经有人使用，如果已经有人使用，则不允许进行修改
        try {
            ValidateUtil.validateThrow(dto);
            dto.valid();
            Card card = dao.loadById(dto.getId(), Card.class);
            BeanPropertyUtil.copy(card, dto);
            dao.update(card);
            log.debug("修改成功：[" + card.toString() + "]");
            return Message.info("修改成功");
        } catch (ValidateException e) {
            if (log.isDebugEnabled()) {
                e.printStackTrace();
            }
            log.error("优惠卡数据格式错误", e);
            return Message.dataError(e.getMessages().toArray(new String[]{}));
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                e.printStackTrace();
            }
            log.error("卡信息修改失败", e);
            return Message.info("修改失败");
        }
    }
}
