package service;

import model.SecurityEvent;
import java.util.*;
import java.util.stream.Collectors;

public class SecurityAnalyzer {
    private List<SecurityEvent> events;

    public SecurityAnalyzer(List<SecurityEvent> events) {
        this.events = events;
    }

    // 1. Filter (Failed Events)
    public List<SecurityEvent> getFailedEvents() {
        return events.stream()
                .filter(e -> e.getStatus().equals("FAILED")) // Lambda
                .collect(Collectors.toList());
    }

    // 2. Grouping (Total attacks by IP)
    public Map<String, Long> getAttackCountByIp() {
        return events.stream()
                .collect(Collectors.groupingBy(SecurityEvent::getIpAddress, Collectors.counting())); // Method Reference 
    }

    // 3. Optional (Top Attacker IP)
    public Optional<String> getTopAttackerIp() {
        return getAttackCountByIp().entrySet().stream()
                .max(Map.Entry.comparingByValue()) 
                .map(Map.Entry::getKey);
    }

    // 4. Filter (Port Scans)
    public long countPortScans() {
        return events.stream()
                .filter(e -> e.getEventType().equals("PORT_SCAN"))
                .count();
    }

    // 5. Parallel Streams 
    public long countFailedEventsParallel() {
        return events.parallelStream()
                .filter(e -> e.getStatus().equals("FAILED"))
                .count();
    }

    // 6. Sorting (Latest Events)
    public List<SecurityEvent> getLatestEvents() {
        return events.stream()
                .sorted((e1, e2) -> e2.getTimestamp().compareTo(e1.getTimestamp())) // Lambda expression & Comparator
                .collect(Collectors.toList());
    }
}
