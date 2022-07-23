package checking.les_10.present_8.task_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Calendar {

    public static void start() {
        System.out.println(".....Welcome to the Calendar.....");
        question();
    }

    private  static final Scanner sc = new Scanner(System.in);


    private static void question() {
        System.out.println("""
                
                Choose next action:
                1. To main menu;
                0. Finish program.""");
        if (sc.nextInt() == 1) mainMenu();
        else end();
    }

    private static void mainMenu() {
        System.out.println("""
                
                ...Main menu...
                Choose next action:
                1. Check month availability;
                2. Display all months of this season;
                3. Display all months with this number of days;
                4. Display all months that have the least number of days;
                5. Display all months that have the most days;
                6. Display next season;
                7. Display previous season;
                8. Display months with a paired number of days;
                9. Display months with an unpaired number of days;
                10. Check the number of days in months for parity;
                0. Finish program.""");

        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println("""
                Enter month name:""");
                monthAvailability(sc.next().toUpperCase(Locale.ROOT));
            }
            case 2 -> {
                System.out.println("""
                Enter season name:""");
                monthInSeason(sc.next().toUpperCase(Locale.ROOT));
            }
            case 3 -> {
                System.out.println("""
                Enter the number of days in a month:""");
                monthWithSuchNumDays(sc.nextInt());
            }
            case 4 -> monthWithLeastNumDays();
            case 5 -> monthWithMostNumDays();
            case 6 -> {
                System.out.println("""
                Enter the name of the current season:""");
                nextSeason(sc.next().toUpperCase(Locale.ROOT));
            }
            case 7 -> {
                System.out.println("""
                Enter the name of the current season:""");
                previousSeason(sc.next().toUpperCase(Locale.ROOT));
            }
            case 8 -> monthWithPairNumDays();
            case 9 -> monthWithUnpairNumDays();
            case 10 -> {
                System.out.println("""
                Enter month name:""");
                checkingForParity(sc.next().toUpperCase(Locale.ROOT));
            }
            default -> end();
        }
    }

    //1
    private static void monthAvailability(String monthName) {

        System.out.println(Arrays.stream(Months.values())
                .filter(month -> month.name().equals(monthName))
                .findFirst()
                .map(month -> month.name() + " is available")
                .orElse(monthName + " is NOT available"));

        question();
    }

    //2
    private static void monthInSeason(String season) {

        String[] monthsInSeason = Arrays.stream(Months.values())
                .filter(month -> month.getSeason().name().equals(season))
                .map(Enum::name)
                .toArray(String[]::new);

        if (monthsInSeason.length > 0) Arrays.stream(monthsInSeason).forEach(System.out::println);
        else System.out.println("Not found....");

        question();
    }

    //3
    private static void monthWithSuchNumDays(int number) {

        String[] months = Arrays.stream(Months.values())
                .filter(month -> month.getDay().equals(number))
                .map(Enum::name)
                .toArray(String[]::new);

        if (months.length > 0) Arrays.stream(months).forEach(System.out::println);
        else System.out.println("Not found....");

        question();
    }

    //4
    private static void monthWithLeastNumDays() {

        int min = Arrays.stream(Months.values())
                .min(Comparator.comparing(Months::getDay))
                .map(Months::getDay).orElse(28);

        String[] months = Arrays.stream(Months.values())
                .filter(month -> month.getDay() <= min)
                .map(Enum::name)
                .toArray(String[]::new);

        if (months.length > 0) Arrays.stream(months).forEach(System.out::println);
        else System.out.println("Not found....");

        question();
    }

    //5
    private static void monthWithMostNumDays() {

        int max = Arrays.stream(Months.values())
                .max(Comparator.comparing(Months::getDay))
                .map(Months::getDay).orElse(31);

        String[] months = Arrays.stream(Months.values())
                .filter(month -> month.getDay() >= max)
                .map(Enum::name).toArray(String[]::new);

        if (months.length > 0) Arrays.stream(months).forEach(System.out::println);
        else System.out.println("Not found....");

        question();
    }

    //6
    private static void nextSeason(String thisSeason) {

        System.out.println(Arrays.stream(Season.values())
                .filter(season -> {
                    boolean exists = false;
                    for (Season value : Season.values()) {
                        if (value.name().equals(thisSeason)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists && season.ordinal() == Season.valueOf(thisSeason).ordinal() + 1)
                        return true;
                    else return exists && season.ordinal() == 0
                            & Season.valueOf(thisSeason).ordinal() == Arrays.stream(Season.values()).count() - 1;
                }).findFirst()
                .map(Enum::name)
                .orElse("Not found"));

        question();
    }

    //7
    private static void previousSeason(String thisSeason) {

        System.out.println(Arrays.stream(Season.values())
                .filter(season -> {
                    boolean exists = false;
                    for (Season value : Season.values()) {
                        if (value.name().equals(thisSeason)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists && season.ordinal() == Season.valueOf(thisSeason).ordinal() - 1)
                        return true;
                    else return exists && season.ordinal() == Arrays.stream(Season.values()).count() - 1
                            & Season.valueOf(thisSeason).ordinal() == 0;
                }).findFirst()
                .map(Enum::name)
                .orElse("Not found"));

        question();
    }

    //8
    private static void monthWithPairNumDays() {

        Arrays.stream(Months.values()).filter(month -> month.getDay() % 2 == 0).forEach(System.out::println);
        question();
    }

    //9
    private static void monthWithUnpairNumDays() {

        Arrays.stream(Months.values()).filter(month -> month.getDay() % 2 != 0).forEach(System.out::println);
        question();
    }

    //10
    private static void checkingForParity(String monthName) {

        System.out.println(Months.valueOf(monthName).getDay() % 2 == 0);
        question();
    }

    //0
    private static void end() {
        System.out.println("Finish of the program.");
    }
}