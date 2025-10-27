package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printRoundResult(List<List<String>> roundResults) {
        for (List<String> round : roundResults) {
            round.forEach(System.out::println);
            System.out.println(); // 라운드 구분용 공백 줄
        }
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_ANNOUNCEMENT + String.join(", ", winners));
    }
}
