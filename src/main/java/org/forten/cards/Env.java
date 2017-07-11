package org.forten.cards;

import org.forten.utils.common.NumberUtil;
import org.forten.utils.system.PropertiesFileReader;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface Env {
    int DEFAULT_PAGESIZE= NumberUtil.parseNumber(PropertiesFileReader.getValue("system/system","DEFAULT_PAGESIZE"),Integer.class);
}
