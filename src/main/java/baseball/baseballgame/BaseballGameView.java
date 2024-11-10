package baseball.baseballgame;

import baseball.utils.Constants;

import java.util.Scanner;

public class BaseballGameView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int ball, int strike) {
        if (ball > 0)
            System.out.printf("%d볼 ", ball);

        if (strike > 0)
            System.out.printf("%d스트라이크 ", strike);

        System.out.println();
    }

    public void printGameEnd() {
        System.out.println(Constants.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public int[] getPlayerInput() {
        int[] playerNumbers = new int[Constants.NUMBER_COUNT];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            playerNumbers[i] = scanner.nextInt();
        }

        return playerNumbers;
    }

    public boolean getPlayerRestart() {
        Scanner scanner = new Scanner(System.in);

        int restart = scanner.nextInt();
        return restart == 1;
    }
}
