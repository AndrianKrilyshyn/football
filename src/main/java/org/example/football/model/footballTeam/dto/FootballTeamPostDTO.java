package org.example.football.model.footballTeam.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.example.football.model.player.Player;

import java.util.List;
@Getter
@Setter
public class FootballTeamPostDTO {
    @NotBlank(message = "Team name cannot be blank")
    @Size(max = 100, message = "Team name cannot exceed 100 characters")
    private String name;
    @PositiveOrZero(message = "Budget must be zero or a positive number")
    private double budget;
    @DecimalMin(value = "0.0", inclusive = true, message = "Commission percentage must be at least 0%")
    @DecimalMax(value = "10.0", inclusive = true, message = "Commission percentage cannot exceed 10%")
    private double commissionPercentage;
    private List<Long> playersId;
}
