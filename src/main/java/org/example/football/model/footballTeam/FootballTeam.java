package org.example.football.model.footballTeam;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FootballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double budget;
    private double commissionPercentage;
    @ElementCollection
    private List<Long> playersId;
}
