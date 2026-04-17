package com.example.booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BookingServiceTest {
    private BookingService bookingService;
    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
        bookingService.addRoom("101");
    }
    @Test
    void testBookingSuccess() { assertTrue(bookingService.bookRoom("101")); }
    @Test
    void testDoubleBookingFails() {
        bookingService.bookRoom("101");
        assertFalse(bookingService.bookRoom("101"));
    }
}