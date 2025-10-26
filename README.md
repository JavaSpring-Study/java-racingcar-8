# 🚗 자동차 경주 게임 (Java RacingCar)

## 🧩 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,) 기준으로 구분하며, 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있다.
- 전진 조건: 0~9 사이 무작위 값 중 **4 이상일 경우 전진**한다.
- 게임 종료 후 누가 우승했는지를 알려준다. (우승자 다수 가능)
- 잘못된 입력 시 `IllegalArgumentException` 발생 후 애플리케이션 종료.

---

## 🧱 패키지 구조
```
src
    ├── main
    │   └── java
    │       └── racingcar
    │           ├── Application.java
    │           ├── controller
    │           │   └── RacingController.java
    │           ├── domain
    │           │   ├── Car.java
    │           │   ├── Cars.java
    │           │   └── RacingGame.java
    │           ├── exception
    │           │   └── InvalidInputException.java
    │           ├── utils
    │           │   ├── RandomUtil.java
    │           │   └── Validator.java
    │           └── views
    │               ├── InputView.java
    │               └── OutputView.java
    └── test
        └── java
            └── racingcar
                ├── ApplicationTest.java
                ├── domain
                │   ├── CarsTest.java
                │   └── CarTest.java
                └── utils
                    └── ValidatorTest.java
```

---
## ✅ 구현할 기능 목록

### 📥 입력 (InputView)
- [x] 사용자로부터 **자동차 이름 목록** 입력받기
  - [x] 쉼표(`,`) 기준으로 분리
  - [x] 각 이름의 길이가 1~5자인지 검증
  - [x] 중복 이름 방지
- [x] 사용자로부터 **시도할 횟수** 입력받기
  - [x] 양의 정수만 허용

---

### ⚙️ 검증 (Validator)
- [x] 이름이 1~5자 범위인지 확인
- [x] 이름에 공백 포함 여부 검사
- [x] 중복 이름 확인
- [x] 시도 횟수가 숫자인지, 1 이상인지 검증

---

### 🏁 도메인 로직 (domain)
#### `Car`
- [x] 자동차 이름과 현재 위치 정보 저장
- [x] 무작위 값(0~9) 중 4 이상일 때 전진
- [x] 이동 후 상태 반환

#### `Cars`
- [x] 여러 대의 자동차 관리
- [x] 모든 자동차의 이동 로직 수행
- [x] 최대 위치(max position) 계산
- [x] 우승자 리스트 반환

#### `RacingGame`
- [x] 게임 초기화 (자동차 등록, 시도 횟수 입력)
- [x] 각 라운드마다 자동차 이동
- [x] 실행 결과 누적 관리
- [x] 최종 우승자 결정

---

### 🎮 컨트롤러 (RacingController)
- [x] 게임 전체 실행 흐름 제어
  - [x] 입력 받기 → 검증 → 경주 진행 → 출력
- [x] 예외 발생 시 메시지 출력 후 애플리케이션 종료
- [x] `IllegalArgumentException` 재전달 (테스트 통과용)

---

### 🖨 출력 (OutputView)
- [x] 실행 결과 라운드별로 출력
- [x] 우승자(단독 또는 공동) 안내 문구 출력
- [x] 예외 발생 시 `[ERROR]` 형태로 메시지 출력

---

### 🔢 랜덤 유틸 (RandomUtil)
- [x] `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)` 사용
- [x] 4 이상일 때 자동차 이동 처리

---

### 🧪 예외 처리 (exception)
- [x] 잘못된 입력 시 `InvalidInputException` 발생
- [x] 메시지는 `[ERROR] ...` 형태로 출력
- [x] `IllegalArgumentException`으로 감싸 재던지기

---

### 🧰 테스트 (ApplicationTest)
- [x] 정상 입력 시 결과 검증
- [x] 잘못된 이름(6자 이상) 입력 시 `IllegalArgumentException` 검증
- [x] Random 값 Mocking (`assertRandomNumberInRangeTest`)으로 결과 제어
- [x] 공동 우승자 검증 (`pobi, jun`)

---

## 💡 실행 예시
```
경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분
doyi,juni,yami
시도할 횟수는 몇 회인가요?
2

실행 결과
doyi : 
juni : -
yami : -

doyi : 
juni : --
yami : --


최종 우승자 : juni, yami
```

---

## 🧾 참고
- Java 21
- Gradle 8.7
- JUnit 5
- camp.nextstep.edu.missionutils  
  - Console: 사용자 입력 처리 (`readLine()`)  
  - Randoms: 무작위 숫자 생성 (`pickNumberInRange(0, 9)`)