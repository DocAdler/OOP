package checking.les_9.task_1;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Target({FIELD, METHOD, LOCAL_VARIABLE})
@Retention(RUNTIME)

public @interface MyAnnot {

    String name();
    int value();
}
