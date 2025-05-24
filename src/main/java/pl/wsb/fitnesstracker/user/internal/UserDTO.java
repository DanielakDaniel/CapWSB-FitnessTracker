package pl.wsb.fitnesstracker.user.internal;

import jakarta.annotation.Nullable;
import java.time.LocalDate;

public record UserDTO(@Nullable Long id, String firstName, String lastName, LocalDate birthdate, String email) { }