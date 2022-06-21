package les_9.task_my_1;

@Service(name = "Simple")
public class SimpleService  {

    public SimpleService() {
    }

    @Init
    public static void met1() {
        System.out.println("Run met1");
    }

    @Init
    public static void met2() {
        System.out.println("Run met2");
    }

    public static void met0() {
        System.out.println("Not run");
    }
}
