package les_2.present6.task1;

public class MainActivity {
    public static void main(String[] args) {

        EmployeeHourPay employeeHourPay = new EmployeeHourPay();
        EmployeeFixPay employeeFixPay = new EmployeeFixPay();

        System.out.println(employeeFixPay.salary());
        System.out.println(employeeHourPay.salary(180));
    }
}
