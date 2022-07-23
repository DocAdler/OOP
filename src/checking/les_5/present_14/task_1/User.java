package checking.les_5.present_14.task_1;

public class User implements Comparable<User>{

    private final String userName;
    private final Integer userAge;
    private final String emailAddress;

    public User(String userName, Integer userAge, String emailAddress) {
        this.userName = userName;
        this.userAge = userAge;
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userName.equals(user.userName)) return false;
        if (!userAge.equals(user.userAge)) return false;
        return emailAddress.equals(user.emailAddress);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + userAge.hashCode();
        result = 31 * result + emailAddress.hashCode();
        return result;
    }

    @Override
    public int compareTo(User user) {
        int result = this.userName.compareTo(user.userName);
        if (result == 0) {
            result = this.userAge.compareTo(user.userAge);
            if (result == 0) {
                result = this.emailAddress.compareTo(user.emailAddress);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return userName + " : " + userAge + " : " + emailAddress;
    }
}
