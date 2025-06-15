package pl.wsb.fitnesstracker.statistics.api;

import java.util.List;

public interface StatisticsService {

    Statistics createStatistics (Statistics statistics);
    Statistics updateStatistics (Statistics statistics);
    void deleteStatistics(Long id);
    List<Statistics> findAllStatisticsWhereCaloriesAreHigherThan(int totalCaloriesBurned);
}
