package checking.les_2.present6.task1;

public class EmployeeHourPay implements Salary {

    @Override
    public int salary() {
        return 0;
    }

    @Override
    public int salary(int hour) {
        return hour * 40;
    }
}
