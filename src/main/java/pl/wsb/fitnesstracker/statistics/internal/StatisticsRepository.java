package pl.wsb.fitnesstracker.statistics.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.statistics.api.Statistics;

import java.util.List;
import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    default Optional<Statistics> findStatisticsById (Long id) {
        return findAll().stream()
                .filter(statistics -> statistics.getId().equals(id))
                .findFirst();
    }

    default List<Statistics> findHigherCalories (int totalCaloriesBurned) {
        return findAll()
                .stream()
                .filter(statistics -> statistics.getTotalCaloriesBurned() > totalCaloriesBurned)
                .toList();
    }

}
