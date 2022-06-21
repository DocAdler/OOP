package les_9.task_my_0;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * ������ ��������� ��������� �������� ������, ������� ����� ������� � RunTime.
 **/

@Documented
@Inherited
@Target(TYPE)
@Retention(RUNTIME)

public @interface Run {

    /**
     * orderNum() �������� ���������� ����� ������,
     * �������� �������� �� ����� ������ � RunTime;
     * <p>
     * �� ��������� - 0;
     */
    int orderNum() default 0;

    /**
     * toRun() = true - ����� ����� ������;
     * <p>
     * toRun() = false - ����� �� ����� ������;
     * <p>
     * �� ��������� - true;
     */
    boolean toRun() default true;
}
