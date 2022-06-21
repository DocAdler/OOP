package checking.les_9.task_my_0;

@Run(orderNum = 3)
public class Print2 {

    public void print21() {
        System.out.println("Class Print2 :: Method print1()");
    }

    @Invoke(orderNum = 3, toInvoke = false)
    public void print22() {
        System.out.println("Class Print2 :: Method print2()");
    }

    public void print23() {
        System.out.println("Class Print2 :: Method print3()");
    }

    @Invoke(orderNum = 1)
    public void print24() {
        System.out.println("Class Print2 :: Method print4()");
    }

    @Invoke
    public void print25() {
        System.out.println("Class Print2 :: Method print5()");
    }

}
