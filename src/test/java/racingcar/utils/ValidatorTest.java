package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.InvalidInputException;

class ValidatorTest {

    @Test
    @DisplayName("쉼표로 구분된 이름을 올바르게 파싱한다")
    void parseCarNames() {
        List<String> result = Validator.validateAndParseNames("pobi,woni,jun");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void nameTooLongThrowsException() {
        assertThatThrownBy(() -> Validator.validateAndParseNames("abcdef"))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("자동차 이름은 1~5자");
    }

    @Test
    @DisplayName("시도 횟수는 숫자여야 하며, 0 이하면 예외 발생")
    void invalidAttemptThrowsException() {
        assertThatThrownBy(() -> Validator.validateAndParseAttempts("-1"))
                .isInstanceOf(InvalidInputException.class);

        assertThatThrownBy(() -> Validator.validateAndParseAttempts("abc"))
                .isInstanceOf(InvalidInputException.class);
    }
}