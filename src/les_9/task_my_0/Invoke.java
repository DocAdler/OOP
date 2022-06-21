package les_9.task_my_0;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Данная аннотация позволяет отмечать методы, которые будут вызваны в RunTime.
 **/
@Documented
@Inherited
@Target(METHOD)
@Retention(RUNTIME)
public @interface Invoke {

    /**
     * orderNum() отмечает порядковый номер метода,
     * согласно которого он будет вызван в RunTime;
     * <p>
     * По умолчанию - 0;
     */
    int orderNum() default 0;

    /**
     * toInvoke() == true - метод будет вызван;
     * <p>
     * toInvoke() == false - метод не будет вызван;
     * <p>
     * По умолчанию - true;
     */
    boolean toInvoke() default true;
}
