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
@Target(METHOD)
@Retention(RUNTIME)
public @interface Invoke {

    /**
     * orderNum() �������� ���������� ����� ������,
     * �������� �������� �� ����� ������ � RunTime;
     * <p>
     * �� ��������� - 0;
     */
    int orderNum() default 0;

    /**
     * toInvoke() == true - ����� ����� ������;
     * <p>
     * toInvoke() == false - ����� �� ����� ������;
     * <p>
     * �� ��������� - true;
     */
    boolean toInvoke() default true;
}
