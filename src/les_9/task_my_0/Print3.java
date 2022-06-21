package les_9.task_my_0;

@Run
public class Print3 {

    @Invoke
    public void print31() {
        System.out.println("Class Print3 :: Method print1()");
    }

    @Invoke
    public void print32() {
        System.out.println("Class Print3 :: Method print2()");
    }

    @Invoke(toInvoke = false)
    public void print33() {
        System.out.println("Class Print3 :: Method print3()");
    }

    public void print34() {
        System.out.println("Class Print3 :: Method print4()");
    }

    @Invoke(toInvoke = false)
    public void print35() {
        System.out.println("Class Print3 :: Method print5()");
    }
}
