package org.example.football.model.match;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.football.model.footballTeam.FootballTeam;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "football_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private FootballTeam homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private FootballTeam awayTeam;

    private String location;

    private LocalDateTime matchDate;
    private String score="N/A";
}
