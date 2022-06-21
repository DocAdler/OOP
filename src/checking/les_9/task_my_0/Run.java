package checking.les_9.task_my_0;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Данная аннотация позволяет отмечать классы, которые будут вызваны в RunTime.
 **/

@Documented
@Inherited
@Target(TYPE)
@Retention(RUNTIME)

public @interface Run {

    /**
     * orderNum() отмечает порядковый номер класса,
     * согласно которого он будет вызван в RunTime;
     * <p>
     * По умолчанию - 0;
     */
    int orderNum() default 0;

    /**
     * toRun() = true - класс будет вызван;
     * <p>
     * toRun() = false - класс не будет вызван;
     * <p>
     * По умолчанию - true;
     */
    boolean toRun() default true;
}
