package ydzhao.weixin.tuisong.util;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.LocalDateTimeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ydzhao.weixin.tuisong.MainStart;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @ClassName JiNianRi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:32
 */
@Component
public class JiNianRi {

    @Value("${lianAi}")
    private String LIANAI;
    @Value("${M}")
    private int M;
    @Value("${D}")
    private int D;

    @Value("${M2}")
    private int M2;
    @Value("${D2}")
    private int D2;

    /**
     * 农历转公历
     *
     * @param chineseDate
     * @return
     */
    private static LocalDateTime ChineseDateToLocalDataTime(ChineseDate chineseDate) {
        return LocalDateTimeUtil.of(chineseDate.getGregorianDate());
    }

    /**
     * 是否下一个日期
     *
     * @param localDateTime
     * @return
     */
    private int getLast(LocalDateTime localDateTime) {
        return LocalDateTime.now().isAfter(localDateTime) ? 1 : 0;
    }

    public int getDays(LocalDateTime target) {
        Duration between = LocalDateTimeUtil.between(LocalDateTime.now(), target);
        return (int) (Math.abs(between.toDays())) + 1;
    }

    public int getLianAi() {
        return getDays(LocalDateTime.parse(LIANAI));
    }

    public int getShengRi() {
        ChineseDate birth = new ChineseDate(LocalDateTime.now().getYear(), M, D);
        LocalDateTime date = ChineseDateToLocalDataTime(new ChineseDate((LocalDateTime.now().getYear() + getLast(ChineseDateToLocalDataTime(birth))), M, D));
        return getDays(date);
    }

    public int getShengRi2() {
        ChineseDate birth = new ChineseDate(LocalDateTime.now().getYear(), M2, D2);
        LocalDateTime date = ChineseDateToLocalDataTime(new ChineseDate((LocalDateTime.now().getYear() + getLast(ChineseDateToLocalDataTime(birth))), M2, D2));
        return getDays(date);
    }

    public int getjinianri() {
        LocalDateTime time = LocalDateTime.parse(LIANAI).withYear(LocalDateTime.now().getYear());
        return getDays(time.plusYears(getLast(time)));
    }

    public static void main(String[] args) {

    }

}
