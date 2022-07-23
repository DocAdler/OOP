package check_11_13.les_11.present_16.task_1;

public class User {

    String name;
    private String email;
    private Long phoneNumb;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Long phoneNumb) {
        this.name = name;
        this.phoneNumb = phoneNumb;
    }

    private User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, Long phoneNumb) {
        this.name = name;
        this.email = email;
        this.phoneNumb = phoneNumb;
    }

    public String getName() {
        return name;
    }

    public Long getPhoneNumb() {
        return phoneNumb;
    }

    public void printName() {
        System.out.println(this.name);
    }

    private void printEmail() {
        System.out.println(this.email);
    }

    public void printNumb() {
        System.out.println(this.phoneNumb);
    }

    public void toPrint(String forPrint) {
        System.out.println(forPrint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        return phoneNumb.equals(user.phoneNumb);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumb.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumb=" + phoneNumb +
                '}';
    }
}
