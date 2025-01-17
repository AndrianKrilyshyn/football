package org.example.football.service;

import org.example.football.model.footballTeam.dto.FootballTeamGetDTO;
import org.example.football.model.footballTeam.dto.FootballTeamPostDTO;
import org.example.football.model.player.dto.PlayerGetDTO;

import java.util.List;

public interface FootballTeamService {
    FootballTeamGetDTO createFootballTeam(FootballTeamPostDTO footballTeamPostDTO);
    FootballTeamGetDTO getFootballTeam(long id);
    FootballTeamGetDTO updateFootballTeam(long id, FootballTeamPostDTO footballTeamPostDTO);
    void deleteFootballTeam(long id);
    List<FootballTeamGetDTO> getAllFootballTeams();

    PlayerGetDTO transferPlayer(long playerId, long newTeamId);

}
