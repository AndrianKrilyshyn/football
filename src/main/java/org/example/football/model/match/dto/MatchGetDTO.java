package org.example.football.model.match.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MatchGetDTO {
    private Long id;
    private Long homeTeamId;
    private Long awayTeamId;
    private String location;
    private LocalDateTime matchDate;
    private String score;
}
