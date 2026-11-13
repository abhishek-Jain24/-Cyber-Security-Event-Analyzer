# 🛡️ Cyber Security Event Analyzer

A Core Java console application built to analyze server security logs. This project uses Java Streams API, Lambda Expressions, Optional, and Parallel Streams to detect failed login attempts, identify top attackers, and process large volumes of log data.

## 📋 Features

- Filter failed security events (Logins, Port Scans, Malware).
- Group attack counts by IP Address.
- Identify the Top Attacker IP safely using `Optional`.
- Count specific event types (like PORT_SCAN).
- Process large datasets quickly using Parallel Streams.
- Sort events to find the most recent security threat.

## 🧠 Topics Covered

- Lambdas & Custom Comparators
- Method References
- Stream API (filter, map, collect, groupingBy, count)
- Optional Class (ifPresentOrElse, max)
- Parallel Streams
- ArrayList (In-Memory storage)
- Custom POJO (Plain Old Java Object)

## 📖 Sample Output
```
=== CYBER SECURITY ANALYZER ===

Total Failed Events: 51

Attack Count by IP:
192.168.1.1 -> 23 attacks
8.8.8.8 -> 24 attacks
10.0.0.5 -> 26 attacks
172.16.0.2 -> 27 attacks

Top Attacker IP: 172.16.0.2 (Most Dangerous)

Total PORT_SCAN events: 25
Failed Events (Parallel Processed): 51

Most Recent Event:
[2026-11-13T12:01:57.375373200] 172.16.0.2 | PORT_SCAN | FAILED
```
