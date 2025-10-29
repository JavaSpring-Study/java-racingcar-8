package racingcar;

import java.util.List;
import java.util.Arrays;

public class NameParser {

    private NameParser() {}

    public static List<String> split(String name) {
        return Arrays.stream(name.split(","))
                .map(String::trim)
                .toList();
    }
}
