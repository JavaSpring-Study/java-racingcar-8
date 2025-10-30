package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMoveStrategy implements MoveStrategy {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return randomNumber >= MOVE_THRESHOLD;
    }
}