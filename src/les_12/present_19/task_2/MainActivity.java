/*
Створити клас Employee, описати даний клас наступними полями: name, id, salary.
Дані поля повинні бути private. Описати getters and setters.
Створити клас Methods де описати всього два методи serialize() and deserealize().
1).Створити метод Main створити екземпляр класу Employee і провести сереалізацію та десереалізацію.
    Результат Десереалізації вивести на консоль.
2). Помітити поле salary модифікатором transient і провести сереалізацію і десереалізацію.
    Результат вивести на екран.
3) Створити колекцію об’єктів Employee, провести сереалізацію та десереалізацю колекції
4) Зробити Salary об’єктом, провести сереалізацію та десереалізацю.
 */

package les_12.present_19.task_2;

import java.io.*;
import java.util.*;

public class MainActivity {

    private static final String ROOT_DIR = "D:\\WayToIT\\OOP\\src\\les_12\\present_19\\task_2";
    private static final String SERIAL = "SERIAL.txt";
    private static final String SERIAL_COLLECTION = "SERIAL_COLLECTION.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee = new Employee("Andrew", 123 , 6500.0, new Salary(10_000.0));
        Methods<Employee> serialSingle = new Methods<>();
        serialSingle.serialize(employee, SERIAL);
        System.out.println(serialSingle.deserialize(SERIAL));

        Collection<Employee> employeeCollection = new ArrayList<>(List.of(
                new Employee("Andrew", 123 , 6500.0, new Salary(10_000.0)),
                new Employee("Tom", 456 , 7500.0, new Salary(12_000.0)),
                new Employee("Sam", 789 , 8500.0, new Salary(13_000.0)),
                new Employee("Mike", 100 , 9500.0, new Salary(14_000.0))
        ));

        Methods<Collection<Employee>> serialCollection = new Methods<>();
        serialCollection.serialize(employeeCollection, SERIAL_COLLECTION);
        System.out.println(serialCollection.deserialize(SERIAL_COLLECTION));
    }

    private static class Employee implements Serializable {

        static final long SERIAL_VERSION_UID = 21_07_2022;
        private String name;
        private Integer id;
        private transient Double salary;
        private Salary salAry;

        public Employee() {}

        public Employee(String name, Integer id, Double salary, Salary salAry) {
            this.name = name;
            this.id = id;
            this.salary = salary;
            this.salAry = salAry;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Salary getSalAry() {
            return salAry;
        }

        public void setSalAry(Salary salAry) {
            this.salAry = salAry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (!name.equals(employee.name)) return false;
            if (!id.equals(employee.id)) return false;
            return salary.equals(employee.salary);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + id.hashCode();
            result = 31 * result + salary.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", salary=" + salary +
                    ", salAry=" + salAry +
                    '}';
        }
    }

    private static class Salary implements Serializable {

        private Double salary;

        public Salary() {
        }

        public Salary(Double salary) {
            this.salary = salary;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Salary salary1 = (Salary) o;

            return salary.equals(salary1.salary);
        }

        @Override
        public int hashCode() {
            return salary.hashCode();
        }

        @Override
        public String toString() {
            return salary.toString();
        }
    }

    private static class Methods<T> {
        void serialize(T t, String fileName) throws IOException {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ROOT_DIR, fileName)));
            oos.writeObject(t);
            oos.flush();
            oos.close();
        }

        T deserialize(String fileName) throws IOException, ClassNotFoundException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ROOT_DIR, fileName)));
            T object = (T) ois.readObject();
            ois.close();
            return object;
        }
    }
}
