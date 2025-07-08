package ui;

import model.Reservation;
import service.ReservationService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final ReservationService reservationService = new ReservationService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("  _      ______  ______  ");
        System.out.println(" | |     |  ___| |  ___| ");
        System.out.println(" | |     | |_    | |_    ");
        System.out.println(" | |     |  _|   |  _|   ");
        System.out.println(" | |____ | |___  | |___  ");
        System.out.println(" \\_____/ \\____/  \\____/ ");
        System.out.println("==========================");
        System.out.println("  👑 HOTEL RESERVATION 👑 ");
        System.out.println("        by. LEE 🏨");
        System.out.println("==========================");
        while (true) {
            System.out.println("\n[1] 예약하기 [2] 전체 예약 보기 [3] 예약 취소 [0] 종료");
            System.out.print("✅선택: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> handleReservation();
                case "2" -> showAllReservations();
                case "3" -> cancelReservation();
                case "0" -> {
                    System.out.println("시스템 종료👋");
                    return;
                }
                default -> System.out.println("⚠️잘못된 입력입니다.");
            }
        }
    }

    private void handleReservation() {
        System.out.print("예약자 성명: ");
        String name = scanner.nextLine();

        System.out.print("예약할 방 번호 (1~5): ");
        int roomNumber = Integer.parseInt(scanner.nextLine());

        boolean success = reservationService.reserveRoom(name, roomNumber);
        if (success) {
            System.out.println("⭕️예약 완료!");
        } else {
            System.out.println("❌예약 실패! (이미 예약된 방이거나 유효하지 않은 방입니다.)");
        }
    }

    private void showAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("💤현재 예약된 방이 없습니다.");
        } else {
            reservations.forEach(System.out::println);
        }
    }

    private void cancelReservation() {
        System.out.print("취소할 방 번호: ");
        int reservationId = Integer.parseInt(scanner.nextLine());

        boolean success = reservationService.cancelReservation(reservationId);
        if (success) {
            System.out.println("예약 취소 완료!");
        } else {
            System.out.println("해당 방은 예약되어 있지 않습니다.");
        }
    }
}