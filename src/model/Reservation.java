package model;

public class Reservation {
    private String guestName;
    private int roomNumber;

    public Reservation(String guestName, int roomNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "방 번호: " + roomNumber + ", 예약자 성명: " + guestName;
    }
}
