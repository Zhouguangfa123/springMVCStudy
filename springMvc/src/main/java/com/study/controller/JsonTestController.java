package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * JsonTestController
 *
 * @author zhougf
 * @date 2019/5/22
 */
@Controller("/jsonTest")
public class JsonTestController {
    @RequestMapping("/jsonToBean")
    public void jsonToBean(Map<String, Object> params) {

    }
}
