package model;

import java.time.LocalDateTime;

public class SecurityEvent {
    private String ipAddress;
    private String eventType;
    private String status;
    private LocalDateTime timestamp;

    public SecurityEvent(String ipAddress, String eventType, String status, LocalDateTime timestamp) {
        this.ipAddress = ipAddress;
        this.eventType = eventType;
        this.status = status;
        this.timestamp = timestamp;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public String getEventType() {
        return eventType;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;   
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + ipAddress + " | " + eventType + " | " + status;
    }
}
