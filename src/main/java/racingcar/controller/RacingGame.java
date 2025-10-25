package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<String> carNames = inputView.inputCarNames();
        int roundCount = inputView.inputRoundCount();

        Cars cars = new Cars(carNames);

        playRounds(cars, roundCount);
        showWinners(cars);
    }

    private void playRounds(Cars cars, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            cars.moveAll();
            outputView.printRoundResults(cars.getCars());
        }
    }

    private void showWinners(Cars cars) {
        List<String> winners = cars.getWinners();
        outputView.printWinners(winners);
    }
}