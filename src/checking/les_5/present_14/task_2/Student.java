package checking.les_5.present_14.task_2;

public class Student implements Comparable<Student> {

   private final String name;
   private final Long phoneNumber;

    public Student(String name, Long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Student student) {
        int result = this.name.compareTo(student.name);
        if (result == 0) {
            result = this.phoneNumber.compareTo(student.phoneNumber);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!name.equals(student.name)) return false;
        return phoneNumber.equals(student.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }
}
