package les_9.task_2;


import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Inherited
@Target(FIELD)
@Retention(RUNTIME)
public @interface Write {

    int value();
    boolean toWrite() default true;
}
