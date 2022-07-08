/*
Завдання(1, 2) робити через RegEx
2. Зробити валідацію для емейл-адрес, зберігати лише ті, які закінчуються на @gmail.com
 */

package checking.les_10.present_11.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity {

    private static final List<String> emails = new ArrayList<>();

    public static void main(String[] args) {

        regEx(new Scanner(System.in).next());
    }

    private static void regEx(String email) {
        Pattern pattern = Pattern.compile("@gmail.com$");
        Matcher matcher = pattern.matcher(email);

        while (!email.equals("end")) {
            if (matcher.find()) {
                emails.add(email);
            }
            regEx(new Scanner(System.in).next());
        }
        System.out.println(emails);
    }
}
