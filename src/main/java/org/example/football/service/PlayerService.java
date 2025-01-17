package org.example.football.service;

import org.example.football.model.player.dto.PlayerGetDTO;
import org.example.football.model.player.dto.PlayerPostDTO;

import java.util.List;

public interface PlayerService {
    PlayerGetDTO createPlayer(PlayerPostDTO player, long teamId);
    PlayerGetDTO getPlayer(long id);
    List<PlayerGetDTO> getAllPlayers();
    PlayerGetDTO updatePlayer(long id, PlayerPostDTO player);
    void deletePlayer(long id);
}
