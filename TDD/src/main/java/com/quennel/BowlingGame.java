package com.quennel;

public class BowlingGame {

    private static final int MAX_FRAMES = 10;
    private static final int MAX_ROLLS = 21;
    private static final int PINS_IN_FRAME = 10;


    private int[] rolls = new int[MAX_ROLLS]; // 最多21次投球（10轮，每轮最多2次投球，最后一轮可能有3次）
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < MAX_FRAMES; frame++) {
            if (isStrike(rollIndex)) {
                score += PINS_IN_FRAME + strikeBonus(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                score += PINS_IN_FRAME + rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == PINS_IN_FRAME;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == PINS_IN_FRAME;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }
}