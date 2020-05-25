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

    JIN("金", "西方", "金生水：水多金沉;强金得水，方挫其锋", "金克木：木多金缺；木弱逢金，必为砍折"),

    MU("木", "东方", "木生火：火多木焚；强木得火，方化其顽", "木克土：土多木折；土弱逢木，必为倾陷"),

    SHUI("水", "北方", "水生木：木多水缩；强水得木，方泄其势", "水克火：火多水干；火弱遇水，必不熄灭"),

    HUO("火", "南方", "火生土：土多火晦；强火得土，方止其焰", "火克金：金多火熄；金弱遇火，必见销熔"),

    TU("土", "中央", "土生金：金多土变；强土得金，方制其壅", "土克水：水多土流；水弱逢土，必为淤塞"),

    DONG_BEI("山", "东北方", "", ""),

    DONG_NAN("风", "东南方", "", ""),

    XI_BEI("天", "西北方", "", ""),

    XI_NAN("地", "西南方", "", "");

    private String value;

    private String direction;
    private String xiangsheng;

    private String xiangke;

}
