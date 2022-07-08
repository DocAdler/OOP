/*
1. Зробити свій Enum, в main методі вивести всі значення цього enum та їх порядкові номери.
2. Додати у свій enum змінну, конструктори, метод з реалізацією, абстрактний метод. В main() методі викликати ці методи.
 */

package checking.les_10.present_8.task_2;

import java.util.Arrays;

public class MainActivity {
    public static void main(String[] args) {

        //1.
        Arrays.stream(Months.values()).forEach(month -> System.out.println(month.name() + " :: " + month.ordinal() + ";"));

        System.out.println("----------------------------");

        //2
        Arrays.stream(Months.values()).forEach(month -> System.out.println(month.name() + " :: " + month.season + " :: " + month.description(month.name()) + " :: " + month.temperature() + ";"));
    }
    private enum Months {

        JANUARY("winter") {
            @Override
            String temperature() {
                return "Temperature: min. -4 / max. 2";
            }
        },
        FEBRUARY("winter") {
            @Override
            String temperature() {
                return "Temperature: min. -3 / max. 3";
            }
        },
        MARCH("spring") {
            @Override
            String temperature() {
                return "Temperature: min. 1 / max. 7";
            }
        },
        APRIL("spring") {
            @Override
            String temperature() {
                return "Temperature: min. 6 / max. 14";
            }
        },
        MAY("spring") {
            @Override
            String temperature() {
                return "Temperature: min. 12 / max. 20";
            }
        },
        JUNE("summer") {
            @Override
            String temperature() {
                return "Temperature: min. 16 / max. 24";
            }
        },
        JULY("summer") {
            @Override
            String temperature() {
                return "Temperature: min. 18 / max. 27";
            }
        },
        AUGUST("summer") {
            @Override
            String temperature() {
                return "Temperature: min. 17 / max. 27";
            }
        },
        SEPTEMBER("autumn") {
            @Override
            String temperature() {
                return "Temperature: min. 13 / max. 21";
            }
        },
        OCTOBER("autumn") {
            @Override
            String temperature() {
                return "Temperature: min. 8 / max. 15";
            }
        },
        NOVEMBER("autumn") {
            @Override
            String temperature() {
                return "Temperature: min. 3 / max. 9";
            }
        },
        DECEMBER("winter") {
            @Override
            String temperature() {
                return "Temperature: min. -2 / max. 4";
            }
        };

        String season;

        abstract String temperature();

        public String description (String monthName) {

            String text = "Average number of rainy days in Odessa: ";
            return switch (Months.valueOf(monthName)) {
                case JANUARY, JUNE, DECEMBER -> text + 6;
                case FEBRUARY, MARCH, APRIL, MAY, NOVEMBER -> text + 5;
                case JULY, AUGUST, SEPTEMBER -> text + 4;
                case OCTOBER -> text + 3;
            };
        }

        Months() {
        }

        Months(String season) {
            this.season = season;
        }
    }
}
