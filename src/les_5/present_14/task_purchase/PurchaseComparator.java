package les_5.present_14.task_purchase;

import java.util.Comparator;

public class PurchaseComparator implements Comparator<Purchase> {
    @Override
    public int compare(Purchase purchase1, Purchase purchase2) {
        return purchase1.amount - purchase2.amount;
    }

    @Override
    public Comparator<Purchase> reversed() {
        return Comparator.super.reversed();
    }
}
