package les_5.present_18.bank;

public class Account<T> implements Comparable<Account<T>>{

    private T id;
    private Double sum;
    private User user;

    public Account(T id, Double sum, User user) {
        this.id = id;
        this.sum = sum;
        this.user = user;
    }

    @Override
    public int compareTo(Account<T> account) {
        int result = this.user.getName().compareTo(account.user.getName());
        if (result == 0) {
            result = this.sum.compareTo(account.sum);
            if (result == 0) {
                result = this.user.getPhone().compareTo(account.user.getPhone());
            }
        }
        return result;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account<?> account = (Account<?>) o;

        if (!id.equals(account.id)) return false;
        if (!sum.equals(account.sum)) return false;
        return user.equals(account.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + sum.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", sum=" + sum +
                ", " + user;
    }
}
