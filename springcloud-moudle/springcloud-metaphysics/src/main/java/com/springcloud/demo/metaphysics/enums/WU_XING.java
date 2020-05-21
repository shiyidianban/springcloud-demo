package com.springcloud.demo.metaphysics.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 五行
 *
 * @author FLY
 * @date 2020-05-21 11:02
 */
@Getter
@AllArgsConstructor
public enum WU_XING {

    JIN("金", "西方"),

    MU("木", "东方"),

    SHUI("水", "北方"),

    HUO("火", "南方"),

    TU("土", "中央");

    private String value;

    private String direction;
}
