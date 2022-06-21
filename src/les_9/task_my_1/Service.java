package les_9.task_my_1;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
@Documented
@Inherited
@Target(TYPE)
@Retention(RUNTIME)

public @interface Service {

    String name();
    boolean lazyLoad() default false;
}
