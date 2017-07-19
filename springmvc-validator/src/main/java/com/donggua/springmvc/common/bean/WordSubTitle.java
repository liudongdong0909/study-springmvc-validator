package com.donggua.springmvc.common.bean;

import java.util.List;

/**
 *  word 二级标题
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-19 下午 04:39
 */
public class WordSubTitle {

    private String subTitleName; // 二级标题内容

    private List<WordSubTitleItem> wordSubTitleItems;// 二级标题下的试题描述或 选项

    public String getSubTitleName() {
        return subTitleName;
    }

    public void setSubTitleName(String subTitleName) {
        this.subTitleName = subTitleName;
    }

    public List<WordSubTitleItem> getWordSubTitleItems() {
        return wordSubTitleItems;
    }

    public void setWordSubTitleItems(List<WordSubTitleItem> wordSubTitleItems) {
        this.wordSubTitleItems = wordSubTitleItems;
    }

    @Override
    public String toString() {
        return "WordSubTitle{" +
                "subTitleName='" + subTitleName + '\'' +
                ", wordSubTitleItems=" + wordSubTitleItems +
                '}';
    }
}
