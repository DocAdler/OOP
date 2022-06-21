package les_9.task_my_1;

@Service(name = "Lazy")
public class LazyService  {

    public LazyService() {
    }

    @Init
    public static void met1() throws Exception {
        System.out.println("Run met3");
    }

    @Init
    public static void met2() throws Exception {
        System.out.println("Run met4");
    }
}
