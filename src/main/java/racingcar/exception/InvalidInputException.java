package racingcar.exception;


//예외처리
public class InvalidInputException extends IllegalArgumentException {
	public InvalidInputException(String message) {
		super(message);
	}
}
