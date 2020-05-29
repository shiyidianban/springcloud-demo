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

    JIA("甲", "栋梁之木", WU_XING.MU),

    YI("乙", "花果之木", WU_XING.MU),

    BING("丙", "太阳之火", WU_XING.HUO),

    DING("丁", "灯烛之火", WU_XING.HUO),

    WU("戊", "城墙之土", WU_XING.TU),

    JI("己", "田园之土", WU_XING.TU),

    GENG("庚", "斧钺之金", WU_XING.JIN),

    XIN("辛", "首饰之金", WU_XING.JIN),

    REN("壬", "江河之水", WU_XING.SHUI),

    GUI("癸", "雨露之水", WU_XING.SHUI),
    ;


    /**
     * 值
     */
    private String value;

    private String desc;

    /**
     * 五行
     */
    private WU_XING wuXing;

    public static TIAN_GAN get(int i) {
        return values()[i];
    }

    public static TIAN_GAN getByValue(String value) {
        for (TIAN_GAN tian_gan : values()) {
            if (tian_gan.getValue().equals(value)) {
                return tian_gan;
            }
        }

        return null;
    }
}
