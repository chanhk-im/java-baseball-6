package baseball;

import baseball.baseballgame.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameController controller = BaseballGameController.getInstance();
        controller.gameStart();
    }
}
