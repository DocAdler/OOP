package les_9.task_my_1;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Inherited
@Target(METHOD)
@Retention(RUNTIME)

public @interface Init {

    boolean suppressException() default false;
}
