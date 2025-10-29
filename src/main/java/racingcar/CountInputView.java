package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CountInputView {

    private CountInputView() {}

    public static String countInput() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String countInput = Console.readLine();

        if (countInput == null || countInput.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        return countInput;
    }
}
