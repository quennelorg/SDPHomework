import com.quennel.BowlingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void testAllGutterBallsShouldScoreZero() {
        rollMany(20, 0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void testAllOnesShouldScoreTwenty() {
        rollMany(20, 1);
        assertEquals(20, game.getScore());
    }

    @Test
    public void testOneSpareFollowedByThreeShouldScoreSixteen() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.getScore());
    }

    @Test
    public void testOneStrikeFollowedByThreeAndFourShouldScoreTwentyFour() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.getScore());
    }

    @Test
    public void testPerfectGameShouldScoreThreeHundred() {
        rollMany(12, 10);
        assertEquals(300, game.getScore());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }
}
