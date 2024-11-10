package baseball.baseballgame;

import baseball.computer.Computer;
import baseball.judgement.Judgement;
import baseball.utils.Constants;

import java.util.ArrayList;

public class BaseballGameController {
    private final ArrayList<Integer> playerNumbers;
    private static BaseballGameController instance;
    private final BaseballGameView baseballGameView;
    private final Computer computer;

    BaseballGameController() {
        playerNumbers = new ArrayList<Integer>(Constants.NUMBER_COUNT);
        baseballGameView = new BaseballGameView();
        computer = Computer.getInstance();
    }

    public void gameStart() {
        baseballGameView.printGameStart();

        while (true) {
            computer.putRandomNumbers();
            while (true) {
                int[] ballAndStrike;
                baseballGameView.printUserInput();
                setPlayerNumbers(baseballGameView.getPlayerInput());
                ballAndStrike = Judgement.compareNumbers();
                baseballGameView.printResult(ballAndStrike[0], ballAndStrike[1]);
                System.out.println("strike: " + ballAndStrike[1]);
                if (Judgement.isPlayerWin(ballAndStrike)) {
                    break;
                }
            }

            baseballGameView.printGameEnd();
            baseballGameView.printRestart();
            if (!baseballGameView.getPlayerRestart()) {
                break;
            }
        }
    }

    public static BaseballGameController getInstance() {
        if (instance == null) {
            instance = new BaseballGameController();
        }
        return instance;
    }


    public ArrayList<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(int[] playerNumbers) {
        this.playerNumbers.clear();

        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            this.playerNumbers.add(playerNumbers[i]);
        }
    }
}
