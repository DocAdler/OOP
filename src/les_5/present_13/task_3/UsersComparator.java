package les_5.present_13.task_3;

import java.util.Comparator;

public class UsersComparator implements Comparator<Users> {

    @Override
    public int compare(Users users1, Users users2) {
        return users1.email.length() - users2.email.length();
    }
}
