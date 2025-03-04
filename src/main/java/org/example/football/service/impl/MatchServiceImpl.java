package org.example.football.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.football.model.footballTeam.FootballTeam;
import org.example.football.model.match.Match;
import org.example.football.model.match.dto.MatchGetDTO;
import org.example.football.model.match.dto.MatchPostDTO;
import org.example.football.model.match.mapper.MatchMapper;
import org.example.football.repository.FootballTeamRepo;
import org.example.football.repository.MatchRepo;
import org.example.football.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepo matchRepo;
    private final FootballTeamRepo footballTeamRepo;
    private final MatchMapper matchMapper;

    @Override
    public MatchGetDTO createMatch(MatchPostDTO dto) {
        Match match = matchMapper.toMatch(dto);
        return matchMapper.toMatchGetDTO(matchRepo.save(match));
    }

    @Override
    public List<MatchGetDTO> getAllMatches() {
        return matchRepo.findAll().stream().map(matchMapper::toMatchGetDTO).collect(Collectors.toList());
    }

    @Override
    public MatchGetDTO getMatchById(Long id) {
        Match match = matchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Match with ID " + id + " not found"));
        return matchMapper.toMatchGetDTO(match);
    }

    @Override
    public MatchGetDTO updateMatch(Long id, MatchPostDTO dto) {
        Match match = matchRepo.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Match with ID " + id + " not found"));
        match.setHomeTeam(footballTeamRepo.findById(dto.getHomeTeamId()).orElseThrow());
        match.setAwayTeam(footballTeamRepo.findById(dto.getAwayTeamId()).orElseThrow());
        match.setLocation(dto.getLocation());
        match.setMatchDate(dto.getMatchDate());
        return matchMapper.toMatchGetDTO(matchRepo.save(match));
    }

    @Override
    public void deleteMatch(Long id) {
        Match match = matchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Match with ID " + id + " not found"));
        matchRepo.delete(match);
    }

    @Override
    public MatchGetDTO setMatchScore(Long matchId, String score) {
        Match match = matchRepo.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match with ID " + matchId + " not found"));

        match.setScore(score);
        return matchMapper.toMatchGetDTO(matchRepo.save(match));
    }
}
