package pl.wsb.fitnesstracker.statistics.api;

import jakarta.annotation.Nullable;

public record StatisticsDto (@Nullable Long id, pl.wsb.fitnesstracker.user.api.User user_id, int totalTrainings, double totalDistance, int totalCaloriesBurned) {

}
