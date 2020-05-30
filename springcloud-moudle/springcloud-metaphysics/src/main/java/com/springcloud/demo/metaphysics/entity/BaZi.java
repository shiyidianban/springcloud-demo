package com.springcloud.demo.metaphysics.entity;

import com.springcloud.demo.metaphysics.enums.DI_ZHI;
import com.springcloud.demo.metaphysics.enums.TIAN_GAN;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 八字
 *
 * @author FLY
 * @date 2020-05-21 11:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaZi {

    private TIAN_GAN tianGanYear;

    private DI_ZHI diZhiYear;

    private TIAN_GAN tianGanMonth;

    private DI_ZHI diZhiMonth;

    private TIAN_GAN tianGanDay;

    private DI_ZHI diZhiDay;

    private TIAN_GAN tianGanTime;

    private DI_ZHI diZhiTime;

    private String date;

    @Override
    public String toString() {
        return "BaZi{" +
                "tianGanYear=" + tianGanYear +
                ", diZhiYear=" + diZhiYear +
                ", tianGanMonth=" + tianGanMonth +
                ", diZhiMonth=" + diZhiMonth +
                ", tianGanDay=" + tianGanDay +
                ", diZhiDay=" + diZhiDay +
                ", diZhiTime=" + diZhiTime +
                ", date='" + date + '\'' +
                '}';
    }

    public String toPrint() {
        StringBuilder str = new StringBuilder();
        str.append("农历 ");
        if (tianGanYear != null && diZhiYear != null) {
            str.append(tianGanYear.getValue() + diZhiYear.getValue() + diZhiYear.getShuXiang() + "年 ");
        }

        if (tianGanMonth != null && diZhiMonth != null) {
            str.append(tianGanMonth.getValue() + diZhiMonth.getValue() + "月 ");
        }

        if (tianGanDay != null && diZhiDay != null) {
            str.append(tianGanDay.getValue() + diZhiDay.getValue() + "日 ");
        }

        if (diZhiTime != null) {
            str.append(tianGanTime.getValue() + diZhiTime.getValue() + "时 " + diZhiTime.getTime());
        }

        return String.valueOf(str);
    }

    public String toBaZi() {
        StringBuilder str = new StringBuilder();
        if (tianGanYear != null && diZhiYear != null) {
            str.append(tianGanYear.getValue() + diZhiYear.getValue() + " ");
        }

        if (tianGanMonth != null && diZhiMonth != null) {
            str.append(tianGanMonth.getValue() + diZhiMonth.getValue() + " ");
        }

        if (tianGanDay != null && diZhiDay != null) {
            str.append(tianGanDay.getValue() + diZhiDay.getValue() + " ");
        }

        if (diZhiTime != null) {
            str.append(tianGanTime.getValue() + diZhiTime.getValue());
        }

        return String.valueOf(str);
    }

    public String toWuXing() {
        StringBuilder str = new StringBuilder();
        if (tianGanYear != null && diZhiYear != null) {
            str.append(tianGanYear.getWuXing().getValue() + diZhiYear.getWuXing().getValue() + "年 ");
            str.append(tianGanYear.getDesc() + diZhiYear.getDesc() + "  ");
        }

        if (tianGanMonth != null && diZhiMonth != null) {
            str.append(tianGanMonth.getWuXing().getValue() + diZhiMonth.getWuXing().getValue() + "月 ");
            str.append(tianGanMonth.getDesc() + diZhiMonth.getDesc() + "  ");

        }

        if (tianGanDay != null && diZhiDay != null) {
            str.append(tianGanDay.getWuXing().getValue() + diZhiDay.getWuXing().getValue() + "日 ");
            str.append(tianGanDay.getDesc() + diZhiDay.getDesc() + "  ");

        }

        if (diZhiTime != null) {
            str.append(tianGanTime.getWuXing().getValue() + diZhiTime.getWuXing().getValue() + "时 ");
            str.append(tianGanTime.getDesc() + diZhiTime.getDesc() + " ");

        }

        return String.valueOf(str);
    }
}
