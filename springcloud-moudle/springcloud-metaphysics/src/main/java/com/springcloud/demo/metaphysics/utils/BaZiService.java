package com.springcloud.demo.metaphysics.utils;

import com.springcloud.demo.metaphysics.entity.BaZi;
import com.springcloud.demo.metaphysics.enums.DI_ZHI;
import com.springcloud.demo.metaphysics.enums.TIAN_GAN;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * 生辰八字计算
 *
 * @author FLY
 * @date 2020-05-21 11:23
 */
public class BaZiService {

    private static final String DEMO = "庚子年 辛巳月 戊辰日 18:00";
    /**
     * 格式化八字
     */
    private static final String[] DEMOS = DEMO.split(" ");

    /**
     * 关于阴历的相关信息
     */
    private static int[] lunar_info = {0x04bd8, 0x04ae0, 0x0a570, 0x054d5,
            0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2, 0x04ae0,
            0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2,
            0x095b0, 0x14977, 0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40,
            0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970, 0x06566, 0x0d4a0,
            0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7,
            0x0c950, 0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0,
            0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0, 0x0b550, 0x15355,
            0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
            0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263,
            0x0d950, 0x05b57, 0x056a0, 0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0,
            0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6, 0x095b0,
            0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46,
            0x0ab60, 0x09570, 0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50,
            0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0, 0x0c960, 0x0d954,
            0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0,
            0x0cab5, 0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0,
            0x0a5b0, 0x15176, 0x052b0, 0x0a930, 0x07954, 0x06aa0, 0x0ad50,
            0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
            0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6,
            0x0d250, 0x0d520, 0x0dd45, 0x0b5a0, 0x056d0, 0x055b2, 0x049b0,
            0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0};

    public BaZi initGanZhi(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, df);
        return initGanZhi(dateTime);
    }


    public BaZi initGanZhi(LocalDateTime dateTime) {
        int dayGanZhi, monthGanZhi, yearGanZhi;
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        //获取现在的时间
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.set(year, month - 1, day);
        long dateNow = calendarNow.getTime().getTime();
        //获取1900-01-31的时间
        Calendar calendarAgo = Calendar.getInstance();
        calendarAgo.set(1900, 0, 31);
        long dateAgo = calendarAgo.getTime().getTime();
        //86400000 = 24 * 60 * 60 * 1000
        long daysDistance = (dateNow - dateAgo) / 86400000L;
        float remainder = (dateNow - dateAgo) % 86400000L;
        // 余数大于0算一天
        if (remainder > 0) {
            daysDistance += 1;
        }
        //都是从甲子开始算起以1900-01-31为起点
        //1899-12-21是农历1899年腊月甲子日  40：相差1900-01-31有40天
        dayGanZhi = (int) daysDistance + 40 - 1;
        //1898-10-01是农历甲子月  14：相差1900-01-31有14个月
        monthGanZhi = 14;
        int daysOfYear = 0;
        int i;
        for (i = 1900; i < 2050 && daysDistance > 0; i++) {
            daysOfYear = daysOfYear(i);
            daysDistance -= daysOfYear;
            monthGanZhi += 12;
        }
        if (daysDistance < 0) {
            daysDistance += daysOfYear;
            i--;
            monthGanZhi -= 12;
        }
        // 农历年份
        int myYear = i;
        // 1864年是甲子年
        yearGanZhi = myYear - 1864;
        // 哪个月是闰月
        int leap = lunar_info[myYear - 1900] & 0xf;
        boolean isLeap = false;
        int daysOfLeapMonth = 0;
        for (i = 1; i < 13 && daysDistance > 0; i++) {
            //闰月
            if (leap > 0 && i == (leap + 1) && !isLeap) {
                isLeap = true;
                if ((lunar_info[myYear - 1900] & 0xf) != 0) {
                    daysOfLeapMonth = (lunar_info[myYear - 1900] & 0x10000) == 0 ? 29 : 30;
                } else {
                    daysOfLeapMonth = 0;
                }
                --i;
            } else {
                daysOfLeapMonth = (lunar_info[myYear - 1900] & (0x10000 >> i)) == 0 ? 29 : 30;
            }
            //设置非闰月
            if (isLeap && i == (leap + 1)) {
                isLeap = false;
            }
            daysDistance -= daysOfLeapMonth;
            if (!isLeap) {
                monthGanZhi++;
            }
        }
        if (daysDistance == 0 && leap > 0 && i == leap + 1 && !isLeap) {
            --monthGanZhi;
        }
        if (daysDistance < 0) {
            --monthGanZhi;
        }


        BaZi baZi = new BaZi();
        baZi.setTianGanYear(TIAN_GAN.get(yearGanZhi % 10));
        baZi.setDiZhiYear(DI_ZHI.get(yearGanZhi % 12));
        baZi.setTianGanMonth(TIAN_GAN.get(monthGanZhi % 10));
        baZi.setDiZhiMonth(DI_ZHI.get(monthGanZhi % 12));
        baZi.setTianGanDay(TIAN_GAN.get(dayGanZhi % 10));
        baZi.setDiZhiDay(DI_ZHI.get(dayGanZhi % 12));
        // 顺推天干地支时辰
        setBaZiTianGanTime(baZi, hour);
        return baZi;
    }

    /**
     * 设置顺推天干地支时辰
     */
    private static void setBaZiTianGanTime(BaZi baZi, int hour) {
        if (hour >= 23 || hour < 1) {
            hour = 0;
        } else if (hour % 2 == 0) {
            hour = hour / 2;
        } else {
            hour = hour / 2 + 1;
        }

        // 顺推天干时辰
        switch (baZi.getTianGanDay()) {
            case JIA:
            case JI:
                baZi.setTianGanTime(TIAN_GAN.get(hour % 10));
                break;
            case YI:
            case GENG:
                baZi.setTianGanTime(TIAN_GAN.get((hour + 2) % 10));
                break;
            case BING:
            case XIN:
                baZi.setTianGanTime(TIAN_GAN.get((hour + 4) % 10));
                break;
            case DING:
            case REN:
                baZi.setTianGanTime(TIAN_GAN.get((hour + 6) % 10));
                break;
            case WU:
            case GUI:
                baZi.setTianGanTime(TIAN_GAN.get((hour + 8) % 10));
                break;
            default:
                break;
        }

        baZi.setDiZhiTime(DI_ZHI.get(hour % 12));
    }

    /**
     * @param bazi 庚子年 辛巳月 戊辰日 18:00
     * @return
     */
    public BaZi getBaZiFromGanZhi(String bazi) {
        String[] ganZhi = bazi.split(" ");
        if (ganZhi.length == DEMOS.length) {
            BaZi baZi = new BaZi();
            baZi.setTianGanYear(TIAN_GAN.getByValue(ganZhi[0].split("")[0]));
            baZi.setDiZhiYear(DI_ZHI.getByValue(ganZhi[0].split("")[1]));
            baZi.setTianGanMonth(TIAN_GAN.getByValue(ganZhi[1].split("")[0]));
            baZi.setDiZhiMonth(DI_ZHI.getByValue(ganZhi[1].split("")[1]));
            baZi.setTianGanDay(TIAN_GAN.getByValue(ganZhi[2].split("")[0]));
            baZi.setDiZhiDay(DI_ZHI.getByValue(ganZhi[2].split("")[1]));
            setBaZiTianGanTime(baZi, Integer.valueOf(ganZhi[3].split(":")[0]));
            return baZi;
        }

        return null;
    }

    /**
     * 获取农历某年的总天数
     *
     * @param year
     * @return
     */
    private static int daysOfYear(int year) {
        int sum = 348;
        for (int i = 0x8000; i > 0x8; i >>= 1) {
            sum += (lunar_info[year - 1900] & i) == 0 ? 0 : 1;
        }
        //获取闰月的天数
        int daysOfLeapMonth;
        if ((lunar_info[year - 1900] & 0xf) != 0) {
            daysOfLeapMonth = (lunar_info[year - 1900] & 0x10000) == 0 ? 29 : 30;
        } else {
            daysOfLeapMonth = 0;
        }
        return sum + daysOfLeapMonth;
    }

    public static void main(String[] args) {
////        BaZi a = initGanZhi("2020-05-25 18:30");
//        System.out.println(a.toPrint());
////        BaZi b = getBaZiFromGanZhi("庚子年 辛巳月 戊辰日 18:00");
//        System.out.println(b.toPrint());
//        System.out.println(a.toPrint());
//        System.out.println(a.toBaZi());
//        System.out.println(a.toWuXing());
    }

}
