package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.InvalidInputException;

public class Validator {
	
	//이름 5자이내
	public static List<String> validateAndParseNames(String input) {
		if(input == null || input.trim().isEmpty()) {
			throw new InvalidInputException("자동차 이름을 입력해야 합니다.");
		}
		
		List<String> names = Arrays.stream(input.split(",")) 
				.map(String::trim)
				.collect(Collectors.toList());
		for (String name : names) {
			if(name.isEmpty() || name.length() > 5) {
				throw new InvalidInputException("자동차 이름은 1~5자여야 합니다.");
			}
		}
		
		return names;
	}
	
	
	//시도횟수가 1회이상 및 양수 
	
	public static int validateAndParseAttempts(String input) {
		try {
			int attempt = Integer.parseInt(input.trim());
			if(attempt <= 0) {
				throw new InvalidInputException("시도 횟수는 1 이상이어야 합니다.");
			}
			return attempt;
		} catch (NumberFormatException e) {
			throw new InvalidInputException("시도 횟수는 숫자여야 합니다.");
		}
	}

}
