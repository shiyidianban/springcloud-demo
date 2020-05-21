package com.springcloud.demo.metaphysics.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 地支
 *
 * @author FLY
 * @date 2020-05-21 11:01
 */
@Getter
@AllArgsConstructor
public enum DI_ZHI {

    ZI("子", "阳水", "鼠", "23:00 ~ 00:59", WU_XING.SHUI),

    CHOU("丑", "阴土", "牛", "01:00 ~ 02:59", WU_XING.TU),

    YIN("寅", "阳木", "虎", "03:00 ~ 4:59", WU_XING.MU),

    MAO("卯", "阴木", "兔", "05:00 ~ 06:59", WU_XING.MU),

    CHEN("辰", "阳土", "龙", "07:00 ~ 08:59", WU_XING.TU),

    SI("巳", "阴火", "蛇", "09:00 ~ 10:59", WU_XING.HUO),

    WU("午", "阳火", "马", "11:00 ~ 12:59", WU_XING.HUO),

    WEI("未", "阴土", "羊", "13:00 ~ 14:59", WU_XING.TU),

    SHEN("申", "阳金", "猴", "15:00 ~ 16:59", WU_XING.JIN),

    YOU("酉", "阴金", "鸡", "17:00 ~ 18:59", WU_XING.JIN),

    XU("戌", "阳土", "狗", "19:00 ~ 20:59", WU_XING.TU),

    HAI("亥", "阴水", "猪", "21:00 ~ 22:59", WU_XING.SHUI);


    /**
     * 值
     */
    private String value;

    private String desc;

    /**
     * 属相
     */
    private String shuXiang;

    private String time;

    /**
     * 五行
     */
    private WU_XING wuXing;

    public static DI_ZHI get(int i) {
        return values()[i];
    }
}
