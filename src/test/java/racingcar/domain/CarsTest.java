package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("자동차 이름 리스트로 Cars를 생성할 수 있다")
    void createCars() {
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        assertEquals(3, cars.getSize());
    }

}