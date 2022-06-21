/*
Описати структуру коли людині належить акаунт та зробити можливість

додати акаунт до списку;
видалити акаунт для певної людини;
видалити людину;
показати всю мапу людей та їх акаунти.

Вважаємо, що людина - унікальний ключ, за значення value беремо Account

Map<Person, Account>
 */

package les_6.present_15.task_1;

public class MainActivity {
    public static void main(String[] args) {
        MyMap<User, Account> map = new MyMap<>();
        map.add(new User("Andrew", "andrew1995@gmail.com", 380972162428L), new Account("And95"));
        map.add(new User("Thomas", "thommy97@gmail.com", 380639462828L), new Account("ThommyT"));
        map.add(new User("Mike", "mk.best@gmail.com", 380503306866L), new Account("MBesT"));
        map.add(new User("Sam", "sam.sad@gmail.com", 38067124569L), new Account("SeriousSam"));
        map.add(new User("Sam", "un.sm@gmail.com", 380448964545L), new Account("UncleSam"));

        map.showAll();
        System.out.println("-------------------");
        map.remove(new User("Mike", "mk.best@gmail.com", 380503306866L));

        map.showAll();
        System.out.println("-------------------");
        map.remove(new User("Thomas", "thommy97@gmail.com", 380639462828L), new Account("ThommyT"));

        map.showAll();
        System.out.println("-------------------");
        map.removeAcc(new User("Andrew", "andrew1995@gmail.com", 380972162428L));

        map.showAll();
    }
}
