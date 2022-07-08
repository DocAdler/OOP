/*
3. Вхідним параметром є стрічка :
String str = "I love Java more than my friend. Java is so beautiful.";
перевірити чи є в стрічці слово “Java”;
замінити слово “Java” на “C#”;
замінити всі слова “Java” на “C#”;
 */

package checking.les_10.present_11.task_3;

public class MainActivity {

    private static final String str = "I love Java more than my friend. Java is so beautiful.";

    public static void main(String[] args) {

        javaChecker();
        javaSingleChange();
        javaAllChange();
    }

    private static void javaChecker() {
        System.out.println(MainActivity.str.matches(".*Java.*"));
        System.out.println("-----------------------------------------");
    }

    private static void javaSingleChange() {
        System.out.println(MainActivity.str.replaceFirst("Java", "C#"));
        System.out.println("-----------------------------------------");
    }

    private static void javaAllChange() {
        System.out.println(MainActivity.str.replaceAll("Java", "C#"));
        System.out.println("-----------------------------------------");
    }
}
