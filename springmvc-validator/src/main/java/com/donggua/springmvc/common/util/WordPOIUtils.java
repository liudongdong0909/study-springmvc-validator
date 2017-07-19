package com.donggua.springmvc.common.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * 操作word 工具类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-18 上午 10:16
 */
public class WordPOIUtils {

    /**
     * word 读取解析
     * @param multipartFile
     */
    public static void read(MultipartFile multipartFile) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename();

        // 获取输入流文档
        XWPFDocument xwpfDocument = new XWPFDocument(multipartFile.getInputStream());
        CTDocument1 document = xwpfDocument.getDocument();

        // 获取总页数 总字符数
        CTProperties ctProperties = xwpfDocument.getProperties().getExtendedProperties().getUnderlyingProperties();
        int pages = ctProperties.getPages();// 总页数
        int characters = ctProperties.getCharacters(); // 忽略空格的总字符数，
        int charactersWithSpaces = ctProperties.getCharactersWithSpaces(); // 获取带空格的字符数

        // 获取所有段落
        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {

            if (StringUtils.isBlank(paragraph.getText())){
                continue;
            }

            // 获取段落内容
            String paragraphText = paragraph.getText();

            System.out.println(paragraphText);

            // 获取段落格式 - 对齐方式
            ParagraphAlignment alignment = paragraph.getAlignment();

            System.out.println(alignment);

        }

        System.out.println("总页数：" + pages + "----" + "忽略空格的总字符数：" + characters + "----" + "带有空格的字符数" + charactersWithSpaces);
    }


    /**
     * word 写入解析
     */
    public static void write() throws IOException, InvalidFormatException {

        // 新建一个文档
        XWPFDocument xwpfDocument = new XWPFDocument();

        // 第4段落
        XWPFParagraph xwpfParagraph3 = xwpfDocument.createParagraph();
        xwpfParagraph3.setStyle("1"); // 标题样式失效
        xwpfParagraph3.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun xwpfRun4 = xwpfParagraph3.createRun();
        xwpfRun4.setFontFamily("宋体");
        xwpfRun4.setFontSize(22);
        xwpfRun4.setBold(true);
        xwpfRun4.setText("中文字体测试-居中");
        //xwpfRun4.setUnderline(UnderlinePatterns.DASH_LONG_HEAVY);


        // 创建一个段落
        XWPFParagraph xwpfParagraph = xwpfDocument.createParagraph();
        //xwpfParagraph.setAlignment(ParagraphAlignment.CENTER);
        // 一个XWPFRun 代表具有相同属性的一个区域
        XWPFRun xwpfRun = xwpfParagraph.createRun();
        xwpfRun.setBold(true);
        xwpfRun.setText("1.下列开方中计算正确的是（）");

        XWPFRun xwpfRun2 = xwpfParagraph.createRun();
        xwpfRun2.setColor("FF0000");
        xwpfRun2.setText("红色的字");



        // 创建一个表格
        //xwpfDocument.createTable(5,6);

        // 创建一个图片 TODO
        XWPFParagraph xwpfParagraph2 = xwpfDocument.createParagraph();


        XWPFRun xwpfRun3 = xwpfParagraph2.createRun();

        xwpfRun3.setText("A. ");
        InputStream is = new FileInputStream("C:\\Users\\zjcap_03\\Pictures\\图片133.png");
        int pictureType = XWPFDocument.PICTURE_TYPE_JPEG;
        String ind = xwpfDocument.addPictureData(is, pictureType);
        int id = xwpfDocument.getNextPicNameNumber(pictureType);
        createPicture(ind, id, 25,20, xwpfRun3);
        xwpfRun3.setText("=+2");

        xwpfRun3.setText("  B. ");
        InputStream is2 = new FileInputStream("C:\\Users\\zjcap_03\\Pictures\\图片133.png");
        String ind2 = xwpfDocument.addPictureData(is2, pictureType);
        int id2 = xwpfDocument.getNextPicNameNumber(pictureType);
        createPicture(ind2, id2, 25,20, xwpfRun3);
        xwpfRun3.setText("=-2");

        /*String fileName = "testImageName";
        xwpfRun3.addPicture(is, pictureType, fileName, 100, 100);*/


        OutputStream os = new FileOutputStream("d:/" + System.nanoTime()+ ".docx");

        xwpfDocument.write(os);

        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(is);

    }


    public static void createPicture(String blipId, int id , int width, int height, XWPFRun xwpfRun){
        final  int EMU = 9525;
        width *= EMU;
        height *= EMU;

        CTInline ctInline = xwpfRun.getCTR().addNewDrawing().addNewInline();

        String picXML = "" +
                "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">" +
                "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                "         <pic:nvPicPr>" +
                "            <pic:cNvPr id=\"" + id + "\" name=\"Generated\"/>" +
                "            <pic:cNvPicPr/>" +
                "         </pic:nvPicPr>" +
                "         <pic:blipFill>" +
                "            <a:blip r:embed=\"" + blipId + "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>" +
                "            <a:stretch>" +
                "               <a:fillRect/>" +
                "            </a:stretch>" +
                "         </pic:blipFill>" +
                "         <pic:spPr>" +
                "            <a:xfrm>" +
                "               <a:off x=\"0\" y=\"0\"/>" +
                "               <a:ext cx=\"" + width + "\" cy=\"" + height + "\"/>" +
                "            </a:xfrm>" +
                "            <a:prstGeom prst=\"rect\">" +
                "               <a:avLst/>" +
                "            </a:prstGeom>" +
                "         </pic:spPr>" +
                "      </pic:pic>" +
                "   </a:graphicData>" +
                "</a:graphic>";

        XmlToken xmlToken = null;

        try {
            xmlToken = XmlToken.Factory.parse(picXML);
        } catch (XmlException e) {
            e.printStackTrace();
        }
        ctInline.set(xmlToken);
        ctInline.setDistT(0);
        ctInline.setDistB(0);
        ctInline.setDistL(0);
        ctInline.setDistR(0);

        CTPositiveSize2D ctPositiveSize2D = ctInline.addNewExtent();

        ctPositiveSize2D.setCx(width);
        ctPositiveSize2D.setCy(height);

        CTNonVisualDrawingProps ctNonVisualDrawingProps = ctInline.addNewDocPr();
        ctNonVisualDrawingProps.setId(id);
        ctNonVisualDrawingProps.setName("Picture" + id);
        ctNonVisualDrawingProps.setDescr("Generated");
    }

}
