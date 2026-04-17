package com.example.booking;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class BookingService {
    private final Map<String, Boolean> roomAvailability = new ConcurrentHashMap<>();
    public void addRoom(String roomId) { roomAvailability.put(roomId, true); }
    public boolean bookRoom(String roomId) {
        Boolean wasAvailable = roomAvailability.computeIfPresent(roomId, (key, isAvailable) -> isAvailable ? false : null);
        return wasAvailable != null && !wasAvailable;
    }
    public boolean cancelBooking(String roomId) {
        if (!roomAvailability.containsKey(roomId) || roomAvailability.get(roomId)) return false;
        roomAvailability.put(roomId, true);
        return true;
    }
}