package com.donggua.springmvc.common.util;

import com.donggua.springmvc.common.bean.WordExportResult;
import com.donggua.springmvc.common.bean.WordSubTitle;
import com.donggua.springmvc.common.bean.WordSubTitleItem;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.util.IOUtils;

import java.io.FileInputStream;
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
        exportResult.setTitle("你是猴子请来的吗？");
        exportResult.setTest(imageBase64Encoder());
        List<WordSubTitle> wordSubTitle = exportSubTitleResult();
        exportResult.setWordSubTitles(wordSubTitle);
        return exportResult;
    }

    private static String imageBase64Encoder()  {

        try {
            byte[] bytes = IOUtils.toByteArray(new FileInputStream("C:\\Users\\zjcap_03\\Pictures\\373465801310286818.png"));
            return Base64.encodeBase64String(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static List<WordSubTitle> exportSubTitleResult(){
        List<WordSubTitle> subTitles = new ArrayList<>();
        WordSubTitle subTitle = new WordSubTitle();
        subTitle.setSubTitleName("选择题");
        subTitle.setWordSubTitleItems(exportChoiceSubTitleItems());
        subTitles.add(subTitle);


        WordSubTitle subTitle2 = new WordSubTitle();
        subTitle2.setSubTitleName("填空题");
        subTitle2.setWordSubTitleItems(exportChoiceSubTitleItems2());
        subTitles.add(subTitle2);

        WordSubTitle subTitle3 = new WordSubTitle();
        subTitle3.setSubTitleName("解答题");
        subTitle3.setWordSubTitleItems(exportChoiceSubTitleItems3());
        subTitles.add(subTitle3);

        return subTitles;
    }

    private static List<WordSubTitleItem> exportChoiceSubTitleItems() {
        List<WordSubTitleItem> subTitleItems = new ArrayList<>();
        WordSubTitleItem subTitleItem = new WordSubTitleItem();
        subTitleItem.setDescriptions("1.下列开方中计算正确的是（）");
        subTitleItem.setDescriptionImages(null);
        subTitleItem.setChoiceItems("A. ");
        subTitleItem.setChoiceItemImages("test");
        subTitleItems.add(subTitleItem);
        return subTitleItems;
    }

    private static List<WordSubTitleItem> exportChoiceSubTitleItems2() {
        List<WordSubTitleItem> subTitleItems = new ArrayList<>();
        WordSubTitleItem subTitleItem = new WordSubTitleItem();
        subTitleItem.setDescriptions("1.等差数列求和公式= _____");
        subTitleItem.setDescriptionImages(null);
        subTitleItem.setChoiceItems(null);
        subTitleItem.setChoiceItemImages(null);
        subTitleItems.add(subTitleItem);
        return subTitleItems;
    }
    private static List<WordSubTitleItem> exportChoiceSubTitleItems3() {
        List<WordSubTitleItem> subTitleItems = new ArrayList<>();
        WordSubTitleItem subTitleItem = new WordSubTitleItem();
        subTitleItem.setDescriptions("1.请证明余弦定理");
        subTitleItem.setDescriptionImages(null);
        subTitleItem.setChoiceItems("");
        subTitleItem.setChoiceItemImages("");
        subTitleItems.add(subTitleItem);
        return subTitleItems;
    }
}

