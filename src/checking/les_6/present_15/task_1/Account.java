package checking.les_6.present_15.task_1;

public class Account {

    String nick;

    public Account(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return nick.equals(account.nick);
    }

    @Override
    public int hashCode() {
        return nick.hashCode();
    }

    @Override
    public String toString() {
        return "Account{" +
                "nick='" + nick + '\'' +
                '}';
    }
}
