package com.donggua.springmvc.controller;

import com.donggua.springmvc.common.bean.Result;
import com.donggua.springmvc.common.util.WordPOIUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 使用 poi 进行 Word 导入导出
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-17 下午 01:56
 */
@Controller
@RequestMapping("word/poi")
public class WordPOIController {


    @RequestMapping(value = "export", method = RequestMethod.GET)
    @ResponseBody
    public Result export() throws IOException, InvalidFormatException {

        WordPOIUtils.write();
        return Result.success();
    }

   @RequestMapping(value = "upload", method =  RequestMethod.POST)
    public Result upload(@RequestParam(value = "file", required = true) MultipartFile multipartFile) throws IOException {

        WordPOIUtils.read(multipartFile);
        return Result.success();
    }

}
