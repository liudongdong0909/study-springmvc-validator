package com.donggua.springmvc.common.validator.goups;

import javax.validation.GroupSequence;

/**
 * save 和 update 同时两种检验
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-15 下午 12:26
 */
@GroupSequence({Save.class, Update.class})
public interface All {
}
