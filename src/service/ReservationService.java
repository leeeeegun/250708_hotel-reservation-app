package service;

import model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationService {
    private final List<Reservation> reservations = new ArrayList<>();
    private final int totalRooms = 5;

    public boolean reserveRoom(String guestName, int roomNumber) {
        if (roomNumber < 1 || roomNumber > totalRooms) return false;

        Optional<Reservation> existing = findReservationByRoom(roomNumber);
        if (existing.isPresent()) return false;

        reservations.add(new Reservation(guestName, roomNumber));
        return true;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public boolean cancelReservation(int roomNumber) {
        return reservations.removeIf(r -> r.getRoomNumber() == roomNumber);
    }

    private Optional<Reservation> findReservationByRoom(int roomNumber) {
        return reservations.stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst();
    }
}
