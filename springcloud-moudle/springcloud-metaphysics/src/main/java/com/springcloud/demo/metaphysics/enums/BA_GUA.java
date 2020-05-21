package com.springcloud.demo.metaphysics.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 八卦
 *
 * @author FLY
 * @date 2020-05-21 16:39
 */
@Getter
@AllArgsConstructor
public enum BA_GUA {

    QIAN("乾", "天行健，君子以自强不息", "乾三连", WU_XING.XI_BEI),
    KUN("坤", "地势坤，君子以厚德载物", "坤六断", WU_XING.XI_NAN),
    XUN("巽", "随风巽，君子以申命行事", "巽下断", WU_XING.DONG_NAN),
    ZHEN("震", "渐雷震，君子以恐惧修省", "震仰盂", WU_XING.MU),
    KAN("坎", "善如水，君子以作事谋始", "坎中满", WU_XING.SHUI),
    LI("离", "火同人，君子以类族辨物", "离中虚", WU_XING.HUO),
    DUI("兑", "步泽履，君子以辨民安志", "兑上缺", WU_XING.JIN),
    GEN("艮", "艮山谦，君子以裒多益寡", "艮覆碗", WU_XING.DONG_BEI);

    /**
     * 值
     */
    private String value;

    private String desc;

    private String kouJue;

    private WU_XING wuXing;

}
