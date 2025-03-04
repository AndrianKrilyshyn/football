package org.example.football.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.football.model.footballTeam.FootballTeam;
import org.example.football.model.footballTeam.dto.FootballTeamGetDTO;
import org.example.football.model.footballTeam.dto.FootballTeamPostDTO;
import org.example.football.model.footballTeam.mapper.FootballTeamMapper;
import org.example.football.model.player.Player;
import org.example.football.model.player.dto.PlayerGetDTO;
import org.example.football.model.player.mapper.PlayerMapper;
import org.example.football.repository.FootballTeamRepo;
import org.example.football.repository.PlayerRepo;
import org.example.football.service.FootballTeamService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FootballTeamServiceImpl implements FootballTeamService {
    private final FootballTeamRepo footballTeamRepo;
    private final PlayerRepo playerRepo;
    private final FootballTeamMapper footballTeamMapper;
    private final PlayerMapper playerMapper;

    @Override
    public FootballTeamGetDTO createFootballTeam(FootballTeamPostDTO footballTeamPostDTO) {
        FootballTeam footballTeam = footballTeamMapper.toFootballTeam(footballTeamPostDTO);
        return footballTeamMapper.toFootballTeamGetDTO(footballTeamRepo.save(footballTeam));
    }

    @Override
    public FootballTeamGetDTO getFootballTeam(long id) {
        return footballTeamMapper.toFootballTeamGetDTO(footballTeamRepo.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Football team with ID " + id + " not found")));
    }

    @Override
    public FootballTeamGetDTO updateFootballTeam(long id, FootballTeamPostDTO footballTeamPostDTO) {
        FootballTeam footballTeam = footballTeamRepo.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Football team with ID " + id + " not found"));
        footballTeam.setBudget(footballTeamPostDTO.getBudget());
        footballTeam.setName(footballTeamPostDTO.getName());
        footballTeam.setCommissionPercentage(footballTeamPostDTO.getCommissionPercentage());
        footballTeamRepo.save(footballTeam);
        return footballTeamMapper.toFootballTeamGetDTO(footballTeam);
    }

    @Override
    public void deleteFootballTeam(long id) {
        footballTeamRepo.deleteById(id);
    }

    @Override
    public List<FootballTeamGetDTO> getAllFootballTeams() {
        return footballTeamRepo.findAll().stream().map(footballTeamMapper::toFootballTeamGetDTO).toList();
    }

    @Override
    public PlayerGetDTO transferPlayer(long playerId, long newTeamId) {
        Player player = playerRepo.findById(playerId).orElseThrow(()
                -> new EntityNotFoundException("Player with ID " + playerId + " not found"));
        FootballTeam currentFootballTeam = footballTeamRepo.findById(player.getTeamId()).orElseThrow(()
                -> new EntityNotFoundException("Football team with ID " + player.getTeamId() + " not found"));
        FootballTeam newFootballTeam = footballTeamRepo.findById(newTeamId).orElseThrow(()
                -> new EntityNotFoundException("Football team with ID " + newTeamId + " not found"));

        if (player.getTeamId() == newTeamId) {
            throw new IllegalArgumentException("Player is already in the specified team");
        }

        double transferCost = player.getExperienceMonths() * 100_000.0 / player.getAge();
        double commission = transferCost * (currentFootballTeam.getCommissionPercentage() / 100.0);
        double totalCost = transferCost + commission;

        if (newFootballTeam.getBudget() < totalCost) {
            throw new RuntimeException("Insufficient budget for transfer");
        }

        newFootballTeam.setBudget(newFootballTeam.getBudget() - transferCost);
        newFootballTeam.getPlayers().add(player);
        currentFootballTeam.setBudget(currentFootballTeam.getBudget() + transferCost);
        currentFootballTeam.getPlayers().remove(player);
        player.setTeamId(newTeamId);
        PlayerGetDTO playerGetDTO = playerMapper.playerToPlayerGetDTO(playerRepo.save(player));
        footballTeamRepo.save(newFootballTeam);
        footballTeamRepo.save(currentFootballTeam);
        return playerGetDTO;

    }
}
