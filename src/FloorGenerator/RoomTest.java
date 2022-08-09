package FloorGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @Test
    void isRoomRatioLeast3By2_10x2() {
        Room room = new Room(10, 10);
        assertEquals(false, room.testIsRoomRatioAtLeast3By2(10, 2));
    }

    @Test
    void isRoomRatioLeast3By2_2x10() {
        Room room = new Room(10, 10);
        assertEquals(false, room.testIsRoomRatioAtLeast3By2(2, 10));
    }

    @Test
    void isRoomRatioLeast3By2_10x10() {
        Room room = new Room(10, 10);
        assertEquals(true, room.testIsRoomRatioAtLeast3By2(10, 10));
    }

    @Test
    void isRoomRatioLeast3By2_7x10() {
        Room room = new Room(10, 10);
        assertEquals(true, room.testIsRoomRatioAtLeast3By2(7, 10));
    }

    @Test
    void isRoomRatioLeast3By2_3x6() {
        Room room = new Room(10, 10);
        assertEquals(true, room.testIsRoomRatioAtLeast3By2(3, 6));
    }

    //Room height should be between the minimum room height and the max room height

    @Test
    void createRoomHeight_5() {
        Room room = new Room(10, 10);
        int minRoomHeight = room.getMIN_ROOM_HEIGHT();
        assertTrue(minRoomHeight <= room.testCreateRoomHeight(5));
        assertTrue(5 > room.testCreateRoomHeight(5));
    }

    @Test
    void createRoomHeight_6() {
        Room room = new Room(10, 10);
        int minRoomHeight = room.getMIN_ROOM_HEIGHT();
        assertTrue(minRoomHeight <= room.testCreateRoomHeight(6));
        assertTrue(6 > room.testCreateRoomHeight(6));
    }

    @Test
    void createRoomHeight_100() {
        Room room = new Room(10, 10);
        int minRoomHeight = room.getMIN_ROOM_HEIGHT();
        assertTrue(minRoomHeight <= room.testCreateRoomHeight(100));
        assertTrue(100 > room.testCreateRoomHeight(100));
    }

    @Test
    void createRoomWidth_5() {
        Room room = new Room(10, 10);
        int minRoomWidth = room.getMIN_ROOM_WIDTH();
        assertTrue(minRoomWidth <= room.testCreateRoomWidth(5));
        assertTrue(5 > room.testCreateRoomWidth(5));
    }

    @Test
    void createRoomWidth_15() {
        Room room = new Room(10, 10);
        int minRoomWidth = room.getMIN_ROOM_WIDTH();
        assertTrue(minRoomWidth <= room.testCreateRoomWidth(15));
        assertTrue(15 > room.testCreateRoomWidth(15));
    }

    @Test
    void createRoomWidth_1000() {
        Room room = new Room(10, 10);
        int minRoomWidth = room.getMIN_ROOM_WIDTH();
        assertTrue(minRoomWidth <= room.testCreateRoomWidth(1000));
        assertTrue(1000 > room.testCreateRoomWidth(1000));
    }


}