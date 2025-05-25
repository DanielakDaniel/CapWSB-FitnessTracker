package pl.wsb.fitnesstracker.training.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;
import java.util.Date;

public record TrainingDto(@Nullable Long id, Long user_id, Date starttime, Date endtime, String ActivityType, double distance, double averageSpeed) {

}