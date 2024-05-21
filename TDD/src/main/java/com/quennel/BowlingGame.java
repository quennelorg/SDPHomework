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
            score += scoreForFrame(rollIndex);
            rollIndex = nextRollIndex(rollIndex);
        }
        return score;
    }

    private int scoreForFrame(int rollIndex) {
        if (isStrike(rollIndex)) {
            return strikeScore(rollIndex);
        } else if (isSpare(rollIndex)) {
            return spareScore(rollIndex);
        } else {
            return frameScore(rollIndex);
        }
    }

    private int nextRollIndex(int rollIndex) {
        if (isStrike(rollIndex)) {
            return rollIndex + 1;
        } else {
            return rollIndex + 2;
        }
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == PINS_IN_FRAME;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == PINS_IN_FRAME;
    }

    private int strikeScore(int rollIndex) {
        return PINS_IN_FRAME + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareScore(int rollIndex) {
        return PINS_IN_FRAME + rolls[rollIndex + 2];
    }

    private int frameScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}