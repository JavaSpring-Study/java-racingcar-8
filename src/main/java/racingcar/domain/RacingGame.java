package racingcar.domain;

import java.util.List;

import racingcar.views.OutputView;

//전체 게임의 진행 제어 로직 구현
public class RacingGame {

		private Cars cars;
		private int attemptCount;
		
		
		//이름 시도횟수 초기화
		public void initialize(List<String> carNames, int attemptCount) {
			this.cars = new Cars(carNames);
			this.attemptCount = attemptCount;
		}
		
		public void start(OutputView outputView) {
			outputView.printStartMessage();
			
			for (int i = 0; i < attemptCount; i++) {
				cars.moveAll(); 
				printRoundResult(outputView);
				System.out.println(); 
			}
			
			outputView.printWinners(cars.getWinners());
		}
		
		private void printRoundResult(OutputView outputView) {
			for(Car car : cars.getCars()) {
				outputView.printRoundResult(car.getName(), car.getPosition());
			}
		}
}
