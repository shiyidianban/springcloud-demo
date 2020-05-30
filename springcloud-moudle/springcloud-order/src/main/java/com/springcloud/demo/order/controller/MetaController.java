package com.springcloud.demo.order.controller;

import com.springcloud.demo.metaphysics.utils.BaZiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 测试数据
 *
 * @author FLY
 * @date 2020-05-29 17:17
 */
@RestController
@RequestMapping("/meta")
public class MetaController {

    @Autowired
    BaZiService baZiService;

    @GetMapping("b")
    public String getBaZi() {
        return baZiService.getBaZiFromGanZhi("庚子年 辛巳月 戊辰日 18:00").toPrint();
    }

    @GetMapping("date")
    public String init() {
        return baZiService.initGanZhi(LocalDateTime.now()).toPrint();
    }
}
