package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_OUTPUT_MESSAGE = "\n실행 결과";
    private static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    public void printRoundResults(List<Car> cars) {
        System.out.println(RESULT_OUTPUT_MESSAGE);
        cars.forEach(car -> System.out.println(car.displayCar()));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winner = String.join(DELIMITER, winners);
        System.out.println(WINNER_OUTPUT_MESSAGE + winner);
    }

}