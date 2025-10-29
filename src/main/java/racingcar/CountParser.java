package racingcar;

public class CountParser {

    private CountParser() {}

    public static int parse(String countInput) {
        try {
            return Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
