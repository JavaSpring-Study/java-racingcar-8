package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    private MoveResult() {}

    public static List<Integer> generateMoveResults(List<Integer> results) {
        List<Integer> moves = new ArrayList<>();

        for (Integer result : results) {
            if (result < 4) {
                moves.add(0);
                continue;
            }
            moves.add(1);
        }

        return moves;
    }
}
