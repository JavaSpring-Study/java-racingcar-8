package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ErrorMessage;
import racingcar.message.SuccessMessage;

public class Input {

	//자동차 이름 입력
	public List<String> readCarNameInput() {
		System.out.println(SuccessMessage.INPUT_CAR_NAME_MESSAGE);
		String inputCarName = Console.readLine();

		//구분자가 , 가 아닌 경우
		if (inputCarName.contains(";") || inputCarName.contains("|") || inputCarName.contains(" ")) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_SEPARATOR_ERROR);
		}

		// , 기준으로 carNames 분리
		List<String> carNames = Arrays.stream(inputCarName.split(","))
			.map(String::trim)
			.map(this::validateCarNameInput) // 각 이름 재검증
			.toList();

		Set<String> uniqueCarNames = new HashSet<>();

		// 자동차 이름이 중복이거나 5자리 이상인경우의 예외처리
		for(String carName : carNames) {
			if(carName.trim().length() > 5) {
				throw new IllegalArgumentException(ErrorMessage.ENTER_MORE_FIVE_DIGITS);
			}
			if(!uniqueCarNames.add(carName)) {
				throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME);
			}
		}
		return carNames;
	}

	//자동차 이름 입력 검증
	public String validateCarNameInput(String inputCarName) {
		// 입력하지 않은 경우
		if (inputCarName == null || inputCarName.isBlank()) {
			throw new IllegalArgumentException(ErrorMessage.DO_NOT_ENTER_CAR_NAME);
		}

		// 공백 포함 여부 체크
		if (inputCarName.contains(" ")) {
			throw new IllegalArgumentException(ErrorMessage.TRIM_ERROR);
		}

		// 앞뒤 공백 제거 후 반환
		return inputCarName.trim();
	}

	public Integer readCount() {
		System.out.println(SuccessMessage.INPUT_COUNT_MESSAGE);
		String inputCount = Console.readLine();
		return validateCountInput(inputCount);
	}

	public Integer validateCountInput(String inputCount) {
		// 입력하지 않은 경우
		if (inputCount == null || inputCount.isBlank()) {
			throw new IllegalArgumentException(ErrorMessage.DO_NOT_ENTER_COUNT);
		}

		int count;
		try {
			count = Integer.parseInt(inputCount); // 문자열 → 정수 변환
		} catch (NumberFormatException e) {       // 숫자가 아닌 값 처리
			throw new IllegalArgumentException(ErrorMessage.ENTERED_NON_NUMERIC_VALUE);
		}

		// 음수 또는 0회 시도 예외 처리
		if (count <= 0) {
			throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
		}

		return count;
	}
}
