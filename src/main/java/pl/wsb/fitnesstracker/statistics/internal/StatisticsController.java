package pl.wsb.fitnesstracker.statistics.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.statistics.api.Statistics;
import pl.wsb.fitnesstracker.statistics.api.StatisticsDto;

import java.util.List;

@RestController
@RequestMapping("/v1/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsServiceImpl statisticsService;

    private final StatisticsMapper statisticsMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatisticsDto createStatistics (@RequestBody StatisticsDto statisticsDto) throws InterruptedException {
        Statistics created = statisticsService.createStatistics(statisticsMapper.toEntity(statisticsDto));
        return statisticsMapper.toDto(created);
    }

    @PutMapping("/{statisticsId}")
    public StatisticsDto updateStatistics(@PathVariable Long statisticsId, @RequestBody StatisticsDto statisticsDto) throws InterruptedException {
        Statistics statistics = statisticsMapper.toEntity(statisticsDto);
        statistics.setId(statisticsId);
        Statistics updated = statisticsService.updateStatistics(statistics);
        return statisticsMapper.toDto(updated);
    }

    @GetMapping
    public List<StatisticsDto> getAllStatistics () {
        return statisticsService.findAllStatistics()
                .stream()
                .map(statisticsMapper::toDto)
                .toList();
    }

    @DeleteMapping("/{statisticsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStatistics(@PathVariable Long statisticsId) {
        statisticsService.deleteStatistics(statisticsId);
    }

    @GetMapping
    public List<StatisticsDto> getAllStatisticsWhereCaloriesAreHigherThan(@RequestParam int totalCaloriesBurned) {
        return statisticsService.findAllStatisticsWhereCaloriesAreHigherThan(totalCaloriesBurned)
                .stream()
                .map(statisticsMapper::toDto)
                .toList();
    }
}
