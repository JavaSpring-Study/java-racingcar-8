package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import racingcar.utils.RandomUtil;

//여러 대의 Cars 관리 로직 
public class Cars {
	private final List<Car> cars;
	
	public List<Car> getCars() {
		return cars;
	}

	public Cars(List<String> carNames) {
		this.cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
	}
	
	//모든 자동차 이동 로직 시도
	public void moveAll() {
		for(Car car : cars) {
			int randomNumber = RandomUtil.getRandomNumber();
			car.move(randomNumber);
		}
	}
	
	
	//현재 최고 위치
	private int getMaxPosition() {
		return cars.stream()
				.map(Car::getPosition)
				.max(Comparator.naturalOrder())
				.orElse(0);
	}
	
	//현재 최고 위치를 기준으로 우승자 리스트 Return 
	public List<String> getWinners() {
		int maxPosition = getMaxPosition();
		
		return cars.stream()
				.filter(car->car.getPosition()==maxPosition)
				.map(Car::getName)
				.toList();
	}
	
	

}
