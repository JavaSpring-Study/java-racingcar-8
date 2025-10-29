package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TryCountValidatorTest {

    @Test
    void nonPositive_throws() {
        assertThatThrownBy(() -> CountValidator.countValidate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

}

