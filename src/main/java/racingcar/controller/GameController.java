package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.game.RacingGame;
import racingcar.model.generator.ValueGenerator;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final ValueGenerator generator;

    public GameController(
            InputView inputView,
            OutputView outputView,
            Validator validator,
            ValueGenerator generator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.generator = generator;
    }

    public void run() {
        List<String> names = inputView.readCarNames();
        validator.validateNames(names);

        String attemptsInput = inputView.readAttemptCount();
        int attempts = validator.validateAttempts(attemptsInput);

        Cars cars = Cars.valueOf(names);
        RacingGame game = RacingGame.of(cars, attempts);

        outputView.printResultHeader();

        for (int i = 0; i < attempts; i++) {
            game.playRound(generator);
            outputView.printRoundResult(game.getCurrentRoundSnapshots());
        }
        outputView.printWinners(game.returnWinners());
    }
}