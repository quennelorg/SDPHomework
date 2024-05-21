package com.quennel;

public class BowlingGame {
    private int[] rolls = new int[21]; // 最多21次投球（10轮，每轮最多2次投球，最后一轮可能有3次）
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += rolls[rollIndex] + rolls[rollIndex + 1];
            rollIndex += 2;
        }
        return score;
    }
}