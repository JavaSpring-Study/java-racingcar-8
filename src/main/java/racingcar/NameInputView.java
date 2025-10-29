package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NameInputView {

    private NameInputView() {}

    public static String nameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = Console.readLine();

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("한 글자 이상 이름을 입력해야 합니다.");
        }

        return name;
    }
}
