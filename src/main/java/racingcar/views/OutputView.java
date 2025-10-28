package racingcar.views;

import java.util.List;

public class OutputView {

	// 차수별 실행 결과 및 단독/공동 우승자 문구 
	
	public void printStartMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}
	
	//position : random으로 나온 횟수 
	public void printRoundResult(String name, int position) {
		System.out.println(name + " : " + "-".repeat(position));
	}
	
	public void printWinners(List<String> winners) {
		System.out.println();
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
