package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Validator;
import racingcar.model.generator.RandomValueGenerator;
import racingcar.model.generator.ValueGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        ValueGenerator generator = new RandomValueGenerator();

        GameController controller = new GameController(inputView, outputView, validator, generator);
        controller.run();
    }
}