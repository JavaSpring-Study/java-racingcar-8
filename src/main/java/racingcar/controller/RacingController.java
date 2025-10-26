package racingcar.controller;

import java.util.List;

import racingcar.domain.RacingGame;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;
	private final RacingGame racingGame;
	
	public RacingController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.racingGame = new RacingGame();
	}
	
	public void run() {
		try {
			List<String> carNames = inputView.readCarNames();
			int attemptCount = inputView.readAttemptCount();
			
			racingGame.initialize(carNames, attemptCount);
			racingGame.start(outputView);
			
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			throw e;
		}
	}
	
}
