package les_4.presetn_9;

public class MainActivity {
    public static void main(String[] args) {

        Human human1 = new Human("Володимир", 18, "volod@gmail.com");
        Human human2 = new Human("Андрій", 15, "andr@gmail.com");
        Human human3 = new Human("Дмитро", 25, "dm_25gmail.com");

        checkException(human1);
        checkException(human2);
        checkException(human3);

    }
    private static void checkException(Human human) {

        if (human.getAge() < 18) {
            throw new UnderAgeException("UnderAgeException");
        }

        char[] charEmail = human.getEmail().toCharArray();
        int count = 0;
        for (char c : charEmail) {
            if (c != '@') count++;
            if (count == charEmail.length) throw new IncorrectEmailException("IncorrectEmailException");
        }
    }
}
