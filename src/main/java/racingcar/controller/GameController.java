package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.game.RacingGame;
import racingcar.model.generator.ValueGenerator;
import racingcar.model.vo.RoundLimit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ValueGenerator generator;

    public GameController(InputView inputView, OutputView outputView, ValueGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        List<String> names = inputView.readCarNames();
        String attemptInput = inputView.readAttemptCount();

        Cars cars = Cars.of(names);
        RoundLimit roundLimit = RoundLimit.of(attemptInput);
        RacingGame game = RacingGame.of(cars, roundLimit);
        outputView.printResultHeader();
        for (int i = 0; i < roundLimit.value(); i++) {
            game.playRound(generator);
            outputView.printRoundResult(game.currentRoundSnapshots());
        }
        outputView.printWinners(game.findWinners());
    }
}
