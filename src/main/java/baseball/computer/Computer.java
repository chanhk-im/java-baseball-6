package baseball.computer;

import baseball.utils.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private static Computer instance;
    private ArrayList<Integer> computerNumbers;

    public static Computer getInstance() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }

    public Computer() {
        this.computerNumbers = new ArrayList<Integer>(3);
    }

    public ArrayList<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void putRandomNumbers() {
        computerNumbers.clear();

        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
