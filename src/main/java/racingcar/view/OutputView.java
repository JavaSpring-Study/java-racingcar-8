package racingcar.view;

import racingcar.model.car.CarStatus;

import java.util.List;

public class OutputView {

    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printRoundResult(List<CarStatus> snapshots) {
        for (CarStatus status : snapshots) {
            System.out.println(status.name() + " : " + "-".repeat(status.position()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_ANNOUNCEMENT + String.join(", ", winners));
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
