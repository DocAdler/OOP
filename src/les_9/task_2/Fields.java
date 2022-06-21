package les_9.task_2;

import java.util.ArrayList;
import java.util.List;

public class Fields {

    @Write(value = 1)
    private final String names = "String Field";

    @Write(value = 6)
    private final Integer ages = 26;

    @Write(value = 3, toWrite = false)
    private final Long ageL = 123_000L;

    @Write(value = 4)
    private final boolean bool = true;

    @Write(value = 2)
    private final List<?> list = new ArrayList<>();
}
