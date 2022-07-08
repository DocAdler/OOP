/*
Завдання(1, 2) робити через RegEx
1. Користувач вводить слова з консолі, в масив додавати лише ті, що починаються на “a”.
 */

package checking.les_10.present_11.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity {

    private static final List<String> library = new ArrayList<>();

    public static void main(String[] args) {

        regEx(new Scanner(System.in).next());
    }

    private static void regEx(String word) {

        Pattern pattern = Pattern.compile("^a");
        Matcher matcher = pattern.matcher(word);

        while (!word.equals("end")) {
            if (matcher.find()) {
                library.add(word);
            }
            regEx(new Scanner(System.in).next());
        }
        System.out.println(library);
    }
}
