package org.forten.cards.dto.qo;

import org.forten.cards.Env;
import org.forten.cards.entity.enums.CardStatus;
import org.forten.cards.entity.enums.CardType;
import org.forten.utils.common.EnumUtil;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.PropertiesFileReader;

/**
 * Created by Administrator on 2017/7/11.
 */
public class CardQo {
    private int pageNo;
    private int pageSize;
    private String orderField;
    private String orderType;

    private String typeName;
    private CardType type;
    private String statusName;
    private CardStatus status;

    public CardQo() {
        this.pageNo = 1;
        this.pageSize = Env.DEFAULT_PAGESIZE;
        this.orderField = "createTime";
        this.orderType = "DESC";
    }

    public CardQo(String typeName, String statusName) {
        this();
        setTypeName(typeName);
        setStatusName(statusName);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
        this.type = StringUtil.hasText(typeName) ? EnumUtil.getEnumByName(CardType.class, typeName) : null;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
        this.status = StringUtil.hasText(statusName) ? EnumUtil.getEnumByName(CardStatus.class, statusName) : null;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }
}
