import model.SecurityEvent;
import service.SecurityAnalyzer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<SecurityEvent> logs = new ArrayList<>();
        Random random = new Random();
        
        String[] ips = {"192.168.1.1", "10.0.0.5", "172.16.0.2", "8.8.8.8"};
        String[] types = {"LOGIN", "PORT_SCAN", "MALWARE"};
        String[] statuses = {"SUCCESS", "FAILED"};

        // Generate random security events 
        for (int i = 0; i < 100; i++) {
            String ip = ips[random.nextInt(ips.length)];
            String type = types[random.nextInt(types.length)];
            String status = statuses[random.nextInt(statuses.length)];
            LocalDateTime time = LocalDateTime.now().minusMinutes(random.nextInt(60));
            
            logs.add(new SecurityEvent(ip, type, status, time));
        }

        // Analyze the generated logs
        SecurityAnalyzer analyzer = new SecurityAnalyzer(logs);

        System.out.println("=== CYBER SECURITY ANALYZER ===");

        // 1. Filter (Failed Events)
        List<SecurityEvent> failedEvents = analyzer.getFailedEvents();
        System.out.println("\n Total Failed Events: " + failedEvents.size());

        // 2. Grouping (Attack Count by IP)
        System.out.println("\n Attack Count by IP:");
        analyzer.getAttackCountByIp().forEach((ip, count) -> 
            System.out.println(ip + " -> " + count + " attacks")
        );

        // 3. Optional (Top Attacker IP)
        System.out.print("\n Top Attacker IP: ");
        analyzer.getTopAttackerIp().ifPresentOrElse(
            ip -> System.out.println(ip + " (Most Dangerous)"),
            () -> System.out.println("No attacks found.")
        );

        // 4. Filter (Port Scans)
        System.out.println("\nTotal PORT_SCAN events: " + analyzer.countPortScans());

        // 5. Parallel Streams (Count Failed Events)
        System.out.println(" Failed Events (Parallel Processed): " + analyzer.countFailedEventsParallel());

        // 6. Sorting (Latest Events)
        System.out.println("\n Most Recent Event:");
        analyzer.getLatestEvents().stream().findFirst().ifPresent(System.out::println);
    }
}