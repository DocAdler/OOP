/*
Створити об’єкт Покупка, який має два поля :
ім’я покупки та кількість .
Користувач має ввести список того, що він має купити в магазині.
Після того як він закінчив вводити вивести йому список покупок:

- в алфавітному порядку за ім’ям -> TreeSet  - task_2
- в такому порядку як він вводив -> LinkedHashSet - task_3
- за зменшенням кількості -> TreeSet
- за хеш значенням об’єкта -> HashSet - task_4

Використовувати Set<>!
 */

package checking.les_5.present_14.task_purchase;

import java.util.*;

public class MainActivity {
    private static final SortedSet<Purchase> purchases = new TreeSet<>();
    private static final Set<Purchase> linkedPurchases = new LinkedHashSet<>();
    private static final Set<Purchase> reversePurchase = new TreeSet<>(new PurchaseComparator().reversed());
    private static final Set<Purchase> hashPurchase = new HashSet<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String name;
        int amount;
        System.out.println("Введите список ваших покупок: ");

        while (true){
            System.out.println("Введите название товара:");
            name = sc.next();
            if (Objects.equals(name, "stop") ) {
                out();
                return;
            }

            System.out.println("Введите колличество товара: ");
            amount = sc.nextInt();
            if (amount == 0) {
                out();
                return;
            }

            purchases.add(new Purchase(name, amount));
            linkedPurchases.add(new Purchase(name, amount));
            reversePurchase.add(new Purchase(name, amount));
            hashPurchase.add(new Purchase(name, amount));
        }
    }
    private static void out() {
        System.out.println("""
                Выберите способ отображения Ваших покупок:
                0 - не выводить общий список;
                1 - в алфавитном порядке;
                2 - в порядке заполнения;
                3 - в порядке уменьшения колличества;
                4 - в порядке хэш-значений элементов;
                """);
        int input = sc.nextInt();
        if (input == 1) {
            System.out.println("Список всех Ваших поупок в алфавитном порядке:");
            purchases.forEach(System.out::println);
            out();
        } else if (input == 2) {
            System.out.println("Список всех Ваших поупок в порядке заполнения:");
            linkedPurchases.forEach(System.out::println);
            out();
        } else if (input == 3) {
            System.out.println("Список всех Ваших поупок в порядке уменьшения колличества:");
            reversePurchase.forEach(System.out::println);
            out();
        } else if (input == 4) {
            System.out.println("Список всех Ваших поупок в порядке хэш-значений элементов:");
            List<Purchase> list = new ArrayList<>(hashPurchase);
            list.sort(Comparator.comparingInt(Purchase::hashCode));
            list.stream().map(purchase -> purchase + " " + purchase.hashCode()).forEach(System.out::println);
            out();
        } else if (input == 0 || input > 4) {
            System.out.println("End.");
        }
    }
}