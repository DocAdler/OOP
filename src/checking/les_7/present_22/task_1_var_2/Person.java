package checking.les_7.present_22.task_1_var_2;


import java.util.Calendar;

public class Person {

    private String name;
    private Integer age;
    private Calendar calendar;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        if (calendar == null) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';

        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", calendar=" + calendar.getTime() +
                    '}';
        }

    }
}
