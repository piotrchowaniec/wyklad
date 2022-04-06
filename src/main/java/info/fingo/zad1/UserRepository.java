package info.fingo.zad1;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private static final Collector<Map.Entry<String, Integer>, ?, Map<String, Integer>> linkedHashMapCollector = Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            Integer::sum,
            LinkedHashMap::new
    );
    private static final Comparator<Map.Entry<String, Integer>> byValueReverseComparator = Map.Entry.comparingByValue(Comparator.reverseOrder());


    private final Map<String, Integer> registrationsCount = new HashMap<>();

    public Integer register(String name) {
        return registrationsCount.merge(name, 1, Integer::sum);
    }

    public void delete(String name) {
        registrationsCount.remove(name);
    }

    public Map<String, Integer> getStats(StatisticsMode mode) {
        return switch (mode) {
            case ALL -> registrationsCount.entrySet()
                    .stream()
                    .sorted(byValueReverseComparator)
                    .collect(linkedHashMapCollector);
            case SHORT -> registrationsCount.entrySet()
                    .stream()
                    .sorted(byValueReverseComparator)
                    .limit(3L)
                    .collect(linkedHashMapCollector);
            case IGNORE_CASE -> registrationsCount.entrySet()
                    .stream()
                    .sorted(byValueReverseComparator)
                    .collect(Collectors.toMap(
                            entry -> entry.getKey().toLowerCase(),
                            Map.Entry::getValue,
                            Integer::sum,
                            LinkedHashMap::new
                    ));
        };
    }
}
