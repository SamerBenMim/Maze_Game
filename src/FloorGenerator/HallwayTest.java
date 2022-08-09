package FloorGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HallwayTest {


    @Test
    void getWidth_1() {
        Hallway hallway = new Hallway(10, 10, 5,5);
        assertEquals(5,hallway.getWidth());
    }

    @Test
    void getWidth_2() {
        Hallway hallway = new Hallway(10, 10, 5,9);
        assertEquals(1,hallway.getWidth());
    }

    @Test
    void getHeight_1() {
        Hallway hallway = new Hallway(10, 10, 6,9);
        assertEquals(4,hallway.getHeight());
    }

    @Test
    void getHeight_2() {
        Hallway hallway = new Hallway(1000, 10, 50,9);
        assertEquals(950,hallway.getHeight());
    }
}