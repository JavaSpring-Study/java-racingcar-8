package racingcar.domain;


//한대의 Car 및 이동 로직
public class Car {
	private final String name;
	private int position;
	
	public Car(String name) {
		this.name = name;
		this.position = 0;
	}
	
	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	//4이상이 나올때만 전진 > 이하 나올 경우 전진할 수 없음 
	public void move(int randomNumber) {
		if (randomNumber >= 4) {
			position ++;
		}
	}
}


