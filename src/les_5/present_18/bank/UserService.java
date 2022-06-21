package les_5.present_18.bank;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public interface UserService <A extends Account<?>, U extends User>{

    SortedSet<User> userSet = new TreeSet<>();
    SortedSet<Account<?>> accountSet = new TreeSet<>();
    SortedSet<Account<?>> debitSet = new TreeSet<>();
    SortedSet<Account<?>> creditSet = new TreeSet<>();

    void addUser(User...users);

    void addAccount(Account<?>...accounts);

    Set<U> getUsersSet();

    default void printAllUsers(){
        userSet.forEach(System.out::println);
    }

    Set<A> getAccountsSet();

    default void printAllAccounts(){
        accountSet.forEach(System.out::println);
    }

    Double calcTaxFor(A account);

    default void sort(Account<?>...accounts){
        addDC(accounts);
    }

    static void addDC(Account<?>...accounts) {
        for (Account<?> account : accounts) {
            if (account instanceof DebitAccount) {
                debitSet.add(account);
            } else if (account instanceof CreditAccount) {
                creditSet.add(account);
            }
        }
    }

    default void printAllDebitAccounts() {
        debitSet.forEach(System.out::println);
    }

    Set<A> getDebitSet();

    default void printAllCreditAccounts(){
        creditSet.forEach(System.out::println);
    }

    Set<A> getCreditSet();
}
