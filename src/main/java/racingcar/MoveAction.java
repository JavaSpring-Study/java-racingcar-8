package racingcar;

import java.util.List;
import java.util.Map;

public class MoveAction {

    private MoveAction() {}

    public static void printAction(List<String> names, Map<String, Integer>positions, List<Integer> moves) {

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int move = moves.get(i);

            if (move == 1) {
                positions.put(name, positions.get(name) + 1);
            }
        }

        for (String name : names) {
            int position = positions.get(name);
            System.out.println(name + " : " + "-".repeat(position));
        }
        System.out.println();
    }
}
