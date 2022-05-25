package les_2.present6.task1;

public class EmployeeFixPay implements Salary {

    @Override
    public int salary() {
        return 6500;
    }

    @Override
    public int salary(int day) {
        return 0;
    }
}
