package com.donggua.springmvc.model;

import com.donggua.springmvc.common.validator.goups.Save;
import com.donggua.springmvc.common.validator.goups.Update;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 商品详情类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-15 上午 10:30
 */
public class ItemDetail {

    @NotEmpty(message = "商品地址不能为空", groups = {Save.class, Update.class})
    private String address;

    @NotNull(message = "商品库存不能为空", groups = {Save.class, Update.class})
    private Integer number;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ItemDetail{" +
                "address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
