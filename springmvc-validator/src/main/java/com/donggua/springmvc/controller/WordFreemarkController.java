package com.donggua.springmvc.controller;

import com.donggua.springmvc.common.bean.Result;
import com.donggua.springmvc.common.util.WordFreemarkUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用 freemark 进行 word 导出
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-07-18 上午 09:35
 */
@Controller
@RequestMapping("word/freemark")
public class WordFreemarkController {


    @RequestMapping("export")
    @ResponseBody
    public Result export(){

        WordFreemarkUtils.export();
        return Result.success();
    }
}
