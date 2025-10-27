package racingcar.message;

public final class ErrorMessage {

	private ErrorMessage() {}

	//입출력 관련
	public static final String DO_NOT_ENTER_CAR_NAME = "자동차 이름을 입력하지 않았습니다.";
	public static final String ENTER_MORE_FIVE_DIGITS = "자동차 이름은 5자 이내로 작성해야 합니다.";
	public static final String DUPLICATE_CAR_NAME = "자동차 이름이 중복되었습니다.";
	public static final String TRIM_ERROR = "자동차 이름에 공백이 포함될 수 없습니다.";

}
