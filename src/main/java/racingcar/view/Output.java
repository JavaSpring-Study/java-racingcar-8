package racingcar.view;

import racingcar.message.SuccessMessage;
import racingcar.domain.Car;

import java.util.List;

public class Output {

	// 차수별 결과 출력
	public void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car);
		}
		System.out.println(); // 라운드 구분
	}

	// 최종 우승자 출력
	public void printWinners(List<String> winners) {
		// SuccessMessage 사용
		System.out.println(SuccessMessage.OUTPUT_SUCCESS_MESSAGE + String.join(", ", winners));
	}
}
