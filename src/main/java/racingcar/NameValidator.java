package racingcar;

import java.util.List;

public class NameValidator {

    private NameValidator() {}

    public static List<String> validate(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("한 글자 이상 이름을 입력해야 합니다.");
        }

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하로만 이름 부여가 가능합니다.");
            }

            if (!name.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("영문자만 입력 가능합니다.");
            }

            if (name.isBlank()) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }
        }

        return names;
    }


}
