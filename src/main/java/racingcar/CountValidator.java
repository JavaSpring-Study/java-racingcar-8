package racingcar;

public class CountValidator {

    private CountValidator() {}

    public static int countValidate(int countInput) {
        if (countInput < 1) {
            throw new IllegalArgumentException("1 이상의 시도 횟수를 입력해야 합니다.");
        }

        return countInput;
    }
}
