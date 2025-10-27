package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public static String readAttemptCount() {
        System.out.println(INPUT_ATTEMPTS_MESSAGE);
        return Console.readLine();
    }
}