package les_9.task_my_0;

@Run(orderNum = 2)
public class Print1 {

    @Invoke(orderNum = 2)
    public void print11() {
        System.out.println("Class Print1 :: Method print1()");
    }

    public void print12() {
        System.out.println("Class Print1 :: Method print2()");
    }

    @Invoke
    public void print13() {
        System.out.println("Class Print1 :: Method print3()");
    }

    public void print14() {
        System.out.println("Class Print1 :: Method print4()");
    }

    @Invoke(toInvoke = false)
    public void print15() {
        System.out.println("Class Print1 :: Method print5()");
    }
}
