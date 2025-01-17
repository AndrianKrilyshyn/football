package org.example.football.model.player.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerPostDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Min(value = 18, message = "Player must be at least 18 years old")
    private int age;
    @Positive(message = "Experience months must be positive")
    private int experienceMonths;
}
