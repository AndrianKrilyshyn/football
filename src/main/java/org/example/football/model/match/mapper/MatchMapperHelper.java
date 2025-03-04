package org.example.football.model.match.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.football.model.footballTeam.FootballTeam;
import org.example.football.model.match.Match;
import org.example.football.repository.FootballTeamRepo;
import org.example.football.repository.MatchRepo;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchMapperHelper  {
    private final FootballTeamRepo footballTeamRepo;

    @Named("mapHomeTeamById")
    public FootballTeam mapHomeTeamById(Long homeTeamId) {
        if (homeTeamId == null) {
            throw new IllegalArgumentException("Home team ID must not be null");
        }
        return footballTeamRepo.findById(homeTeamId)
                .orElseThrow(() -> new RuntimeException("Home team not found"));
    }


    @Named("mapAwayTeamById")
    public FootballTeam mapAwayTeamById(Long awayTeamId) {
        if (awayTeamId == null) {
            throw new IllegalArgumentException("Away team ID must not be null");
        }
        return footballTeamRepo.findById(awayTeamId)
                .orElseThrow(() -> new RuntimeException("Away team not found"));
    }


    @Named("mapHomeTeamToId")
    public Long mapHomeTeamToId(FootballTeam homeTeam) {
        return homeTeam != null ? homeTeam.getId() : null;
    }

    @Named("mapAwayTeamToId")
    public Long mapAwayTeamToId(FootballTeam awayTeam) {
        return awayTeam != null ? awayTeam.getId() : null;
    }
}
