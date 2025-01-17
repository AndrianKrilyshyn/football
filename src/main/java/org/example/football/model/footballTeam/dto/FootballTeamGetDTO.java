package org.example.football.model.footballTeam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.football.model.player.Player;

import java.util.List;
@Getter
@Setter
public class FootballTeamGetDTO {
    private Long id;
    private String name;
    private double budget;
    private double commissionPercentage;
    private List<Long> playersId;
}
