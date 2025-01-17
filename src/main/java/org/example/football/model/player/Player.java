package org.example.football.model.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.football.model.footballTeam.FootballTeam;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int experienceMonths;
    private Long teamId;

}
