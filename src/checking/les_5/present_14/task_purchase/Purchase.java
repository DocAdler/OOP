package checking.les_5.present_14.task_purchase;

public class Purchase implements Comparable<Purchase> {

    String name;
    Integer amount;

    public Purchase(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return this.name.compareTo(purchase.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (!name.equals(purchase.name)) return false;
        return amount.equals(purchase.amount);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  "Товар: " + name  +
                ", в колличестве: " + amount + " шт.";
    }
}
