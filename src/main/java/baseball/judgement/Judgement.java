package baseball.judgement;

import baseball.baseballgame.BaseballGameController;
import baseball.computer.Computer;
import baseball.utils.Constants;

import java.util.ArrayList;
import java.util.Objects;

public class Judgement {
    public static int[] compareNumbers() {
        int[] ballAndStrike = new int[2];

        BaseballGameController controller = BaseballGameController.getInstance();
        Computer computer = Computer.getInstance();

        ArrayList<Integer> playerNumbers = controller.getPlayerNumbers();
        ArrayList<Integer> computerNumbers = computer.getComputerNumbers();

        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            if (Objects.equals(playerNumbers.get(i), computerNumbers.get(i))) {
                ballAndStrike[1]++;
            } else if (playerNumbers.contains(computerNumbers.get(i))) {
                ballAndStrike[0]++;
            }
        }

        return ballAndStrike;
    }

    public static boolean isPlayerWin(int[] ballAndStrike) {
        return ballAndStrike[1] == Constants.NUMBER_COUNT;
    }
}
