package com.donggua.springmvc.common.bean;

import java.util.List;

/**
 * freemark 导出 work对象
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-19 下午 04:37
 */
public class WordExportResult {

    private String title;//页面以及标题

    private List<WordSubTitle> wordSubTitles;// 二级标题

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<WordSubTitle> getWordSubTitles() {
        return wordSubTitles;
    }

    public void setWordSubTitles(List<WordSubTitle> wordSubTitles) {
        this.wordSubTitles = wordSubTitles;
    }

    @Override
    public String toString() {
        return "WordExportResult{" +
                "title='" + title + '\'' +
                ", wordSubTitles=" + wordSubTitles +
                '}';
    }
}
