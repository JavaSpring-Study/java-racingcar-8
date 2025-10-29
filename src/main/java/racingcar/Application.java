package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String plyeNames = NameInputView.nameInput();
        List<String> names = NameParser.split(plyeNames);
        names = NameValidator.validate(names);

        String playCount = CountInputView.countInput();
        int count = CountParser.parse(playCount);
        count = CountValidator.countValidate(count);

        RacingGame.run(names, count);

    }
}
