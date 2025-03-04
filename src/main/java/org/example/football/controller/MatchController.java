package org.example.football.controller;

import lombok.RequiredArgsConstructor;
import org.example.football.model.footballTeam.dto.FootballTeamGetDTO;
import org.example.football.model.match.dto.MatchGetDTO;
import org.example.football.model.match.dto.MatchPostDTO;
import org.example.football.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    public ResponseEntity<MatchGetDTO> createMatch(@RequestBody MatchPostDTO dto) {
        MatchGetDTO matchGetDTO = matchService.createMatch(dto);
        return new ResponseEntity<>(matchGetDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MatchGetDTO>> getAllMatches() {
        List<MatchGetDTO> listMatches = matchService.getAllMatches();
        return new ResponseEntity<>(listMatches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchGetDTO> getMatchById(@PathVariable Long id) {
        MatchGetDTO matchGetDTO = matchService.getMatchById(id);
        return new ResponseEntity<>(matchGetDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MatchGetDTO> updateMatch(@PathVariable Long id, @RequestBody MatchPostDTO dto) {
        MatchGetDTO matchGetDTO = matchService.updateMatch(id, dto);
        return new ResponseEntity<>(matchGetDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return  ResponseEntity.ok("Match with ID " + id + " has been successfully deleted.");
    }

    @PatchMapping("/{id}/score")
    public ResponseEntity<MatchGetDTO> setMatchScore(@PathVariable Long id, @RequestParam String score) {
        MatchGetDTO matchGetDTO = matchService.setMatchScore(id, score);
        return new ResponseEntity<>(matchGetDTO, HttpStatus.OK);
    }
}
