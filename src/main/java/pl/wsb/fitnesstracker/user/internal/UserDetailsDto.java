package pl.wsb.fitnesstracker.user.internal;

import jakarta.annotation.Nullable;
import java.time.LocalDate;

record UserDetailsDto(@Nullable Long id, String firstName, String lastName, LocalDate birthdate, String email) {

}