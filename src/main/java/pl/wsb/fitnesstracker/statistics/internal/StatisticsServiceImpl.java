package pl.wsb.fitnesstracker.statistics.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.statistics.api.Statistics;
import pl.wsb.fitnesstracker.statistics.api.StatisticsProvider;
import pl.wsb.fitnesstracker.statistics.api.StatisticsService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class StatisticsServiceImpl implements StatisticsProvider, StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Override
    public Statistics createStatistics(final Statistics statistics) {
        if (statistics.getId() != null) {
            throw new IllegalArgumentException("Statistic has already DB ID, create is not permitted!");
        }
        return statisticsRepository.save(statistics);
    }

    @Override
    public Statistics updateStatistics(final Statistics statistics) {
        if (statistics.getId() == null) {
            throw new IllegalArgumentException("Statistic ID cannot be empty!");
        }
        getStatistics(statistics.getId()).orElseThrow(() -> new IllegalArgumentException("Statistic does not exist!"));
        return statisticsRepository.save(statistics);
    }

    @Override
    public Optional<Statistics> getStatistics(final Long statisticsId) {return statisticsRepository.findById(statisticsId);}

    @Override
    public List<Statistics> findAllStatistics() {return statisticsRepository.findAll();}

    @Override
    public void deleteStatistics(final Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Statistics ID cannot be empty!");
        }
        getStatistics(id).orElseThrow(() -> new IllegalArgumentException("Statistics does not exist!"));
        statisticsRepository.deleteById(id);
    }

    @Override
    public List<Statistics> findAllStatisticsWhereCaloriesAreHigherThan(final int totalCaloriesBurned) {
        return statisticsRepository.findHigherCalories(totalCaloriesBurned);
    }

}
