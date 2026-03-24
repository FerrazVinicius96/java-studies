package com.java360.pmanager.infrastructure.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveProjectDataDto {

    @NotNull(message = "Name required.")
    @Size(min = 1, max = 80)
    private final String name;

    @NotNull(message = "Description required.")
    @Size(min = 1, max = 150)
    private final String description;

    @NotNull(message = "Initial date required.")
    private final LocalDate initialDate;

    @NotNull(message = "Final date required.")
    private final LocalDate finalDate;


    private final String status;

    @AssertTrue(message = "Dates are not consistent")
    @SuppressWarnings("unused")
    private boolean isInitialDateBeforeFinalDate() {
        return initialDate.isBefore(finalDate);
    }
}
