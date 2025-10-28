package racingcar.views;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputView {
	//사용자에서 자동차 이름과 시도 횟수를 입력받는 역할 
	public List<String> readCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
		String input = Console.readLine();
		return Validator.validateAndParseNames(input);
		}
		
	public int readAttemptCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String input = Console.readLine();
		return Validator.validateAndParseAttempts(input);
	}
}
