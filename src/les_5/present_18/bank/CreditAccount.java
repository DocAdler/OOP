package les_5.present_18.bank;

public class CreditAccount extends Account<Integer>{

    public CreditAccount(Integer id, Double sum, User user) {
        super(id, sum, user);
    }

    @Override
    public String toString() {
        return "CreditAccount{" + super.toString() + "}";
    }
}
