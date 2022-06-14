/*
Написати структуру Банк :
1. Створити клас Account, від нього унаслідувати різні типи акаунтів :
    DebitAccount(в нього поле Id є стрінговим), CreditAccount(в нього поле Id є числовим).
2. Створити клас User.
3. Створити параметризований інтерфейс - User service,
    який буде в якості параметрі приймати Account(та наслідників) та User і буде мати наступні методи :

        - показати всіх користувачів(посортованих по user name)
        - показати всі рахунки
        - повернути кількість податку для людини, яка розраховується як загальну суму на рахунку * 0,05
 */

package checking.les_5.present_18.bank;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        User u1 = new User("Andrew", 380972162428L);
        User u2 = new User("Tom", 380664509863L);
        User u3 = new User("Mike", 380443306595L);
        User u4 = new User("Sam", 380506649950L);
        service.addUser(u1, u2, u3, u4);

        service.addAccount(
                new DebitAccount("001", 5000D, u1),
                new DebitAccount("002", 6500D, u2),
                new CreditAccount(3, 2200.50, u3),
                new CreditAccount(4,3099.69, u4)
        );
        service.sort(
                new DebitAccount("001", 5000D, u1),
                new DebitAccount("002", 6500D, u2),
                new CreditAccount(3, 2200.50, u3),
                new CreditAccount(4,3099.69, u4)
        );

        service.printAllUsers();
        System.out.println("-------------------");

        service.printAllAccounts();
        System.out.println("-------------------");

        service.printAllDebitAccounts();
        System.out.println("-------------------");

        service.printAllCreditAccounts();
        System.out.println("-------------------");

        System.out.println(service.calcTaxFor(new DebitAccount("001", 5000D, u1)));
        System.out.println(service.calcTaxFor(new CreditAccount(3, 2200.50, u3)));
    }
}
