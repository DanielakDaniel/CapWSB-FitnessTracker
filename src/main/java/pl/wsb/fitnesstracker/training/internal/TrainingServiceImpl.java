package pl.wsb.fitnesstracker.training.internal;

import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.user.api.User;
import java.util.List;
import java.util.Optional;

// TODO: Provide Implementation and correct the return type of the method getTraining
public class TrainingServiceImpl implements TrainingProvider {

    private final TrainingRepository trainingRepository;

    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

    @Override
    public List<Training> findTrainingsByUserId() {return trainingRepository.findAll();}

    @Override
    public List<Training> findTrainingsAfterDate() {return trainingRepository.findAll();}

    @Override
    public List<Training> findTrainingsByActivity() {return trainingRepository.findAll();}

    @Override
    public Training createTraining(final Training training) {
        log.info("Creating Training {}", training);
        if (training.getId() != null) {
            throw new IllegalArgumentException("Training has already DB ID, update is not permitted!");
        }
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(final Training training) {
        log.info("Updating Training {}", training);
        if (training.getId() == null) {
            throw new IllegalArgumentException("Training ID cannot be empty!");
        }
        getTraining(training.getId()).orElseThrow(() -> new IllegalArgumentException("Training does not exist!"));
        return trainingRepository.save(training);
    }

}
