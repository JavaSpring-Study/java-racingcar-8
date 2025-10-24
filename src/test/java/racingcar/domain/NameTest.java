package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = { "pobi", "jun", "woni" })
    @DisplayName("이름 생성하기")
    void createName(String validName) {
        Name name = new Name(validName);
        assertEquals(validName, name.getValue());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "    "})
    @DisplayName("빈 이름 또는 NULL 값이면 예외가 발생한다")
    void validateEmptyName(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "abcdef", "123456" })
    @DisplayName("5자를 초과하는 이름이면 예외가 발생한다")
    void validateNameLength(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}