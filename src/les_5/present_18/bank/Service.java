package les_5.present_18.bank;

import java.util.*;

public class Service implements UserService<Account<?>, User>{

//    SortedSet<User> userSet = new TreeSet<>();
//    SortedSet<Account<?>> accountSet = new TreeSet<>();
//    SortedSet<Account<?>> debitSet = new TreeSet<>();
//    SortedSet<Account<?>> creditSet = new TreeSet<>();

    @Override
    public void addUser(User... users) {
        userSet.addAll(List.of(users));
    }

    @Override
    public void addAccount(Account<?>... accounts) {
        accountSet.addAll(List.of(accounts));
    }

    @Override
    public Set<User> getUsersSet() {
        return this.userSet;
    }

    @Override
    public Set<Account<?>> getAccountsSet() {
        return this.accountSet;
    }

    @Override
    public Double calcTaxFor(Account<?> account) {
        return account.getSum()*0.05D;
    }

    @Override
    public Set<Account<?>> getDebitSet() {
        return this.debitSet;
    }

    @Override
    public Set<Account<?>> getCreditSet() {
        return this.creditSet;
    }
}
