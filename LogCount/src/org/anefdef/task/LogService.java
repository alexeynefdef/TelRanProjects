package org.anefdef.task;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class LogService {

    /**
     * Method, that counts all the entries by Url.
     * @param entries a list of all Log Entries
     * @return Map<Url,Entries Value>
     */
    public Map<String, Long> sumOfEntriesByUrl(List<LogEntry> entries) {
       return entries.stream()
                .collect(groupingBy(LogEntry::getUrl,counting()));
    }

    /**
     * Method, that counts how many unique Users entered each Url.
     * @param entries a list of all Log Entries
     * @return Map<Url, Unique Users Value>
     */
    public Map<String, Integer> sumOfUniqueUsersByUrl(List<LogEntry> entries) {
        return entries.stream()
                .collect(groupingBy(LogEntry::getUrl,
                        mapping(LogEntry::getUserName,collectingAndThen(toSet(), Set::size))));
    }

    /**
     * Method, that counts how many unique Urls entered each unique User.
     * @param entries a list of all Log Entries
     * @return Map<Unique User, Unique Url Entries Value>
     */
    public Map<String, Integer> sumOfUniqueUrlEntriesByUsers(List<LogEntry> entries) {
        return entries.stream()
                .collect(groupingBy(LogEntry::getUserName,
                        mapping(LogEntry::getUrl,collectingAndThen(toSet(), Set::size))));
    }
}
