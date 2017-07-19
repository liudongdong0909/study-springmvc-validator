package com.donggua.springmvc.common.bean;

/**
 * 二级标题下对象信息类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-19 下午 04:47
 */
public class WordSubTitleItem {

    private  String descriptions; // 试题条目描述

    private String descriptionImages;// 试题条目中包含的图片

    private String choiceItems;// 试题选项

    private String choiceItemImages;// 试题选项中包含的图片

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getDescriptionImages() {
        return descriptionImages;
    }

    public void setDescriptionImages(String descriptionImages) {
        this.descriptionImages = descriptionImages;
    }

    public String getChoiceItems() {
        return choiceItems;
    }

    public void setChoiceItems(String choiceItems) {
        this.choiceItems = choiceItems;
    }

    public String getChoiceItemImages() {
        return choiceItemImages;
    }

    public void setChoiceItemImages(String choiceItemImages) {
        this.choiceItemImages = choiceItemImages;
    }

    @Override
    public String toString() {
        return "WordSubTitleItem{" +
                "descriptions='" + descriptions + '\'' +
                ", descriptionImages='" + descriptionImages + '\'' +
                ", choiceItems='" + choiceItems + '\'' +
                ", choiceItemImages='" + choiceItemImages + '\'' +
                '}';
    }
}
