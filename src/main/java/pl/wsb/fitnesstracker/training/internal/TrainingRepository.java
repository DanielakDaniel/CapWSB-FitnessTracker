package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface TrainingRepository extends JpaRepository<Training, Long> {

    default Optional<Training> findTrainingById(Long id) {
        return findAll().stream()
                .filter(training -> training.getId().equals(id))
                .findFirst();
    }

    default List<Training> findTrainingsByUserId(Long user_id) {
        return findAll().stream()
                .filter(training -> training.getUser().getId().equals(user_id))
                .collect(Collectors.toList());
    }

    default List<Training> findTrainingsAfterDate(Date endTime) {
        return findAll().stream()
                .filter(training -> training.getStartTime().after(endTime))
                .collect(Collectors.toList());
    }

    default List<Training> findTrainingsByActivity(ActivityType activityType) {
        return findAll().stream()
                .filter(training -> training.getActivityType().equals(activityType))
                .collect(Collectors.toList());
    }

}
