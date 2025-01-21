package org.example.football.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.football.model.footballTeam.FootballTeam;
import org.example.football.model.player.Player;
import org.example.football.model.player.dto.PlayerGetDTO;
import org.example.football.model.player.dto.PlayerPostDTO;
import org.example.football.model.player.mapper.PlayerMapper;
import org.example.football.repository.FootballTeamRepo;
import org.example.football.repository.PlayerRepo;
import org.example.football.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepo playerRepo;
    private final FootballTeamRepo footballTeamRepo;
    private final PlayerMapper playerMapper;
    @Override
    public PlayerGetDTO createPlayer(PlayerPostDTO player, long teamId) {
        FootballTeam footballTeam = footballTeamRepo.findById(teamId).orElseThrow(()
                -> new EntityNotFoundException("Football team with ID " + teamId + " not found"));
        Player newPlayer = playerMapper.toPlayer(player);
        newPlayer.setTeamId(footballTeam.getId());
        footballTeam.getPlayers().add(newPlayer);
        PlayerGetDTO playerGetDTO = playerMapper.playerToPlayerGetDTO(playerRepo.save(newPlayer));
        footballTeamRepo.save(footballTeam);
        return playerGetDTO;
    }

    @Override
    public PlayerGetDTO getPlayer(long id) {
        return playerMapper.playerToPlayerGetDTO(playerRepo.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Player with ID " + id + " not found")));
    }

    @Override
    public List<PlayerGetDTO> getAllPlayers() {
        return playerRepo.findAll().stream().map(playerMapper::playerToPlayerGetDTO).toList();
    }

    @Override
    public PlayerGetDTO updatePlayer(long id, PlayerPostDTO player) {
        Player playerToUpdate = playerRepo.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Player with ID " + id + " not found"));
        playerToUpdate.setName(player.getName());
        playerToUpdate.setAge(player.getAge());
        playerToUpdate.setExperienceMonths(player.getExperienceMonths());
        return playerMapper.playerToPlayerGetDTO(playerRepo.save(playerToUpdate));
    }

    @Override
    public void deletePlayer(long id) {
        playerRepo.deleteById(id);
    }
}
