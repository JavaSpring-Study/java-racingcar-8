package racingcar.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValueGenerator implements ValueGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    @Override
    public int getValue() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
