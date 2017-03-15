package com.donggua.springmvc.model;

import com.donggua.springmvc.common.validator.goups.Save;
import com.donggua.springmvc.common.validator.goups.Update;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 商品表
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 01:18
 */
public class Item {

    @NotNull(message = "商品id不能为空", groups = {Update.class})
    private Long id;

    @NotEmpty(message = "商品名称不能为空", groups = {Update.class, Save.class})
    private String title;

    @NotNull(message = "商品价格不能为空", groups = {Update.class, Save.class})
    private Long price;

    private Date created;

    // 内嵌对象的校验 使用 @Valid 注解
    @Valid
    private ItemDetail itemDetail;

    public ItemDetail getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(ItemDetail itemDetail) {
        this.itemDetail = itemDetail;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", created=" + created +
                ", itemDetail=" + itemDetail +
                '}';
    }
}
