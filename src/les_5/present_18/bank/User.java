package les_5.present_18.bank;

public class User implements Comparable<User> {

    private String name;
    private Long phone;

    public User(String name, Long phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public int compareTo(User user) {
        int result = this.name.compareTo(user.getName());
        if (result == 0) {
            result = this.phone.compareTo(user.phone);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        return phone.equals(user.phone);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
