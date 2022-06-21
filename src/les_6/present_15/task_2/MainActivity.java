/*
Описати структуру коли людині може належати список акаунтів та зробити можливість
- додати людину до списку;
- додати акаунт до списку;
- видалити акаунт для певної людини;
- видалити людину;
- показати всю мапу людей та їх акаунти.

Вважаємо, що людина - унікальний ключ, за значення value беремо List<Account>

Map<Person, List<Account> >
 */

package les_6.present_15.task_2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {

        List<Account> accSam = new ArrayList<>(List.of(
                new Account("SeriousSam"),
                new Account("UncleSam"),
                new Account("Sammy")
        ));

        List<Account> accAndrew = new ArrayList<>(List.of(
                new Account("And.Best"),
                new Account("Andy95"),
                new Account("AndyNight")
        ));

        List<Account> accMike = new ArrayList<>(List.of(
                new Account("mTyson"),
                new Account("Mike2000"),
                new Account("TurboMike")
        ));

        MyMap<User, List<Account>, Account> map = new MyMap<>();
        map.add(new User("Andrew", "andrew1995@gmail.com", 380972162428L), accAndrew);
        map.add(new User("Mike", "mk.best@gmail.com", 380503306866L), accMike);
        map.add(new User("Sam", "sam.sad@gmail.com", 38067124569L));


        map.showMap();
        map.addAcc(new User("Sam", "sam.sad@gmail.com", 38067124569L), new Account("UncleSam"));

        System.out.println("-----------");
        map.showMap();

        map.removeAcc(new User("Andrew", "andrew1995@gmail.com", 380972162428L), new Account("Andy95"));
        System.out.println("-----------");
        map.showMap();

    }
}
