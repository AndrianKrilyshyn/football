package org.example.football.model.match.mapper;

import org.example.football.model.match.Match;
import org.example.football.model.match.dto.MatchGetDTO;
import org.example.football.model.match.dto.MatchPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MatchMapperHelper.class})
public interface MatchMapper {
    @Mapping(target = "homeTeam", source = "homeTeamId", qualifiedByName = "mapHomeTeamById")
    @Mapping(target = "awayTeam", source = "awayTeamId", qualifiedByName = "mapAwayTeamById")
    Match toMatch(MatchPostDTO postDTO);
    @Mapping(target = "homeTeamId", source = "homeTeam", qualifiedByName = "mapHomeTeamToId")
    @Mapping(target = "awayTeamId", source = "awayTeam", qualifiedByName = "mapAwayTeamToId")
    MatchGetDTO toMatchGetDTO(Match match);
}
