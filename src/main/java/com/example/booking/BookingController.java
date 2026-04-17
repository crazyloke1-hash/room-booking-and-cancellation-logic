package com.example.booking;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/rooms")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
        this.bookingService.addRoom("101");
    }
    @PostMapping("/{id}/book")
    public String bookRoom(@PathVariable String id) { return bookingService.bookRoom(id) ? "Room booked!" : "Already booked!"; }
    @PostMapping("/{id}/cancel")
    public String cancelBooking(@PathVariable String id) { return bookingService.cancelBooking(id) ? "Cancelled!" : "Nothing to cancel!"; }
}