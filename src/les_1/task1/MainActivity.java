package les_1.task1;

public class MainActivity {
    public static void main(String[] args) {

        Students student1 = new Students();
        student1.setFirstName("Дима");
        student1.setLastName("Дмитров");
        student1.setAge(20);

        Students student2 = new Students("Степан", "Степанов",16);

        System.out.println(student1);
        System.out.println(student2);
    }
}
