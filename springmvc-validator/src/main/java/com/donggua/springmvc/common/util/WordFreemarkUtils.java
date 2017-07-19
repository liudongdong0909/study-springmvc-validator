package com.donggua.springmvc.common.util;

import com.donggua.springmvc.common.bean.WordExportResult;
import com.donggua.springmvc.common.bean.WordSubTitle;
import com.donggua.springmvc.common.bean.WordSubTitleItem;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * freemark 生成word方式
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-19 下午 03:44
 */
public class WordFreemarkUtils {


    public static void export(){
        String templateName = "word.ftl";
        String targetPath = "D:/TEST.doc";

        Map<String, Object> model = new HashedMap();
        // TODO
        WordExportResult exportModel = exportModel();
        model.put("model", exportModel);

        FreemarkUtil.process(templateName, targetPath, model);
    }

    /**
     * 组装word输出结果
     * @return
     */
    private static WordExportResult exportModel(){

        WordExportResult exportResult = new WordExportResult();
        exportResult.setTitle("你是猴子请来的逗逼吗？");
        List<WordSubTitle> wordSubTitle = exportSubTitleResult();
        exportResult.setWordSubTitles(wordSubTitle);
        return exportResult;
    }

    private static List<WordSubTitle> exportSubTitleResult(){
        List<WordSubTitle> subTitles = new ArrayList<>();
        WordSubTitle subTitle = new WordSubTitle();
        subTitle.setSubTitleName("选择题");
        subTitle.setWordSubTitleItems(exportChoiceSubTitleItems());
        subTitles.add(subTitle);


        WordSubTitle subTitle2 = new WordSubTitle();
        subTitle2.setSubTitleName("填空题");
        // TODO

        subTitles.add(subTitle2);

        WordSubTitle subTitle3 = new WordSubTitle();
        subTitle3.setSubTitleName("解答题");
        // TODO

        subTitles.add(subTitle3);

        return subTitles;
    }

    private static List<WordSubTitleItem> exportChoiceSubTitleItems() {
        List<WordSubTitleItem> subTitleItems = new ArrayList<>();
        WordSubTitleItem subTitleItem = new WordSubTitleItem();
        subTitleItem.setDescriptions("1.下列开方中计算正确的是（）");
        return subTitleItems;
    }
}
