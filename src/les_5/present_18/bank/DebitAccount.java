package les_5.present_18.bank;

public class DebitAccount extends Account<String> {

    public DebitAccount(String id, Double sum, User user) {
        super(id, sum, user);
    }

    @Override
    public String toString() {
        return "DebitAccount{" + super.toString() + "}";
    }
}
