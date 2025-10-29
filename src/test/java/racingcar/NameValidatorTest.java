package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NameValidatorTest {

    @Test
    void emptyList_throws() {
        assertThatThrownBy(() -> NameValidator.validate(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 글자 이상");
    }

    @Test
    void blankElement_throws() {
        assertThatThrownBy(() -> NameValidator.validate(List.of("pobi", " ")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
