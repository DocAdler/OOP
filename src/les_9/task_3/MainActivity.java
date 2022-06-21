/*
Максимум:
https://www.baeldung.com/java-datetimeformatter
Створити методи які дозволять конвертувати дату з
Date --> LocalDate.
Date --> LocalTime,
Date --> LocalDateTime

 */
package les_9.task_3;

import java.time.*;
import java.util.*;

public class MainActivity {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        System.out.println(localDate(date));
        System.out.println(localTime(date));
        System.out.println(localDateTime(date));
    }

    /**
      Instant instant = date.toInstant();
      ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
      LocalDate localDate = zonedDateTime.toLocalDate();
     */

    public static LocalDate localDate(Date date) {
        return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public static LocalTime localTime(Date date) {
        // ~~//~~ //
        return LocalTime.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
    }

    public static LocalDateTime localDateTime(Date date) {
        // ~~//~~ //
        return LocalDateTime.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}
