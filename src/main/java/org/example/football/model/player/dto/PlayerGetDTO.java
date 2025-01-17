package org.example.football.model.player.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerGetDTO {
    private Long id;
    private String name;
    private int age;
    private int experienceMonths;
    private Long teamId;
}
