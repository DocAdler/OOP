package checking.les_10.present_8.task_3;

import static checking.les_10.present_8.task_3.Season.*;

public enum Months {
    JANUARY(31, WINTER),
    FEBRUARY(28, WINTER),
    MARCH(31, SPRING),
    APRIL(30, SPRING),
    MAY(31, SPRING),
    JUNE(30, SUMMER),
    JULY(31, SUMMER),
    AUGUST(31, SUMMER),
    SEPTEMBER(30, AUTUMN),
    OCTOBER(31, AUTUMN),
    NOVEMBER(30, AUTUMN),
    DECEMBER(31, WINTER);

    private final Integer day;
    private final Season season;

    Months(Integer day, Season season) {
        this.day = day;
        this.season = season;
    }

    public Integer getDay() {
        return day;
    }

    public Season getSeason() {
        return season;
    }

}
