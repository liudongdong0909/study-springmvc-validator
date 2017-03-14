package com.donggua.springmvc.controller;

import com.donggua.springmvc.common.bean.Result;
import com.donggua.springmvc.common.validator.goups.Save;
import com.donggua.springmvc.common.validator.goups.Update;
import com.donggua.springmvc.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 商品管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 01:22
 */
@Controller
@RequestMapping("item")
public class ItemController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result createItem(@RequestBody @Validated({Save.class}) Item item) {

        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("保存商品信息: item= {}", item);
            }
            return Result.success();

        } catch (Exception e) {
            LOGGER.error("保存商品信息失败: item= {}", item, e);
        }
        return Result.error();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result updateItem(@RequestBody @Validated({Update.class}) Item item) {
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("修改商品信息: item= {}", item);
            }

            return Result.success();
        } catch (Exception e) {
            LOGGER.error("修改商品信息失败: item= {}", item, e);
        }
        return Result.error();
    }
}
