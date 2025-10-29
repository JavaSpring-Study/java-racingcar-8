package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    public static void run(List<String> names, int count) {
        Map<String, Integer> positions = initPositions(names);
        System.out.println("\n실행 결과");

        for (int i = 0; i < count; i++) {
            playRound(names, positions);
        }

        int max = 0;
        for (Integer distance : positions.values()) {
            if (distance > max) {
                max = distance;
            }
        }

        List<String> winners = new ArrayList<>();
        for (String name : positions.keySet()) {
            if (positions.get(name) == max) {
                winners.add(name);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", " , winners));
    }

    private static Map<String, Integer> initPositions(List<String> names) {
        Map<String, Integer> positions = new LinkedHashMap<>();
        for (String name : names) {
            positions.put(name, 0);
        }
        return positions;
    }

    private static void playRound(List<String> names, Map<String, Integer> positions) {
        List<Integer> randomNumbers = RandomGenerator.numbersForOneRound(1, names);
        List<Integer> moves = MoveResult.generateMoveResults(randomNumbers);
        MoveAction.printAction(names, positions, moves);
    }
}
