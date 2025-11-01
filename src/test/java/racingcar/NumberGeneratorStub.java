package racingcar;

import racingcar.domain.NumberGenerator;

public class NumberGeneratorStub implements NumberGenerator {

	private final int number;

	public NumberGeneratorStub(int number) {
		this.number = number;
	}

	@Override
	public int generate() {
		return number;
	}
}
