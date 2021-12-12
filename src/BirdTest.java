import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    @Test
    void getBird() {
        Bird b = new Bird();
        Rectangle r = b.getBird();
        assertEquals(r,b.getBird());
    }

    @Test
    void birdLogic() {
        Bird b = new Bird();
        b.setGravity(10);
        b.birdLogic();
        assertTrue(b.getGravity()==11);
    }
}