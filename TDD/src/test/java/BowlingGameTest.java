import com.quennel.BowlingGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    public void testAllGutterBalls() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0); // 每一轮的两次扔球都没有碰到球
        }
        assertEquals(0, game.getScore()); // 总得分应该为0
    }

    @Test
    public void testAllOnes() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1); // 每次扔球击倒一个球瓶
        }
        assertEquals(20, game.getScore()); // 总得分应该为20
    }
}
