package com.springcloud.demo.metaphysics.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 天干
 *
 * @author FLY
 * @date 2020-05-21 11:01
 */
@Getter
@AllArgsConstructor
public enum TIAN_GAN {

    JIA("甲", WU_XING.MU),

    YI("乙", WU_XING.MU),

    BING("丙", WU_XING.HUO),

    DING("丁", WU_XING.HUO),

    WU("戊", WU_XING.TU),

    JI("己", WU_XING.TU),

    GENG("庚", WU_XING.JIN),

    XIN("辛", WU_XING.JIN),

    REN("壬", WU_XING.SHUI),

    GUI("癸", WU_XING.SHUI),
    ;


    /**
     * 值
     */
    private String value;

    /**
     * 五行
     */
    private WU_XING wuXing;

    public static TIAN_GAN get(int i) {
        return values()[i];
    }
}
