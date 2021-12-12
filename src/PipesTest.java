import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PipesTest {
    Pipes pipe = new Pipes(150);
    @Test
    void getPipeTop() {
        Rectangle r = pipe.getPipeTop();
        assertEquals(r,pipe.getPipeTop());
    }
    @Test
    void getPipeBottom() {
        Rectangle r = pipe.getPipeBottom();
        assertEquals(r,pipe.getPipeBottom());
    }
   @Test
    void move() {
        int a = pipe.getPipeTop().x;
        pipe.move(5);
        assertTrue(a == (pipe.getPipeTop().x + 5));
    }
}