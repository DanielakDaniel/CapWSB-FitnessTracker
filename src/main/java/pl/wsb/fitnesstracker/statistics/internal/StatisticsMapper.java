package pl.wsb.fitnesstracker.statistics.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.statistics.api.Statistics;
import pl.wsb.fitnesstracker.statistics.api.StatisticsDto;

@Component
public class StatisticsMapper {

    public StatisticsDto toDto(Statistics statistics) {
        return new StatisticsDto(
                statistics.getId(),
                statistics.getUser(),
                statistics.getTotalTrainings(),
                statistics.getTotalDistance(),
                statistics.getTotalCaloriesBurned());
    }

    public Statistics toEntity(StatisticsDto statisticsDto) {
        return new Statistics(
                statisticsDto.id(),
                statisticsDto.user_id(),
                statisticsDto.totalTrainings(),
                statisticsDto.totalDistance(),
                statisticsDto.totalCaloriesBurned());
    }
}
