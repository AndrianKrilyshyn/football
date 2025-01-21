package org.example.football.model.footballTeam.mapper;

import org.example.football.model.footballTeam.FootballTeam;
import org.example.football.model.footballTeam.dto.FootballTeamGetDTO;
import org.example.football.model.footballTeam.dto.FootballTeamPostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FootballTeamMapper {
    FootballTeam toFootballTeam(FootballTeamPostDTO footballTeamPostDTO);
    FootballTeamGetDTO toFootballTeamGetDTO(FootballTeam footballTeam);
}
