/*
�������� ��������� ���� :
1. �������� ���� Account, �� ����� ����������� ��� ���� ������� :
    DebitAccount(� ����� ���� Id � ���������), CreditAccount(� ����� ���� Id � ��������).
2. �������� ���� User.
3. �������� ���������������� ��������� - User service,
    ���� ���� � ����� �������� �������� Account(�� ���������) �� User � ���� ���� ������� ������ :

        - �������� ��� ������������(������������ �� user name)
        - �������� �� �������
        - ��������� ������� ������� ��� ������, ��� ������������� �� �������� ���� �� ������� * 0,05
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
