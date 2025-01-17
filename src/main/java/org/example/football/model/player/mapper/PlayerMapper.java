package org.example.football.model.player.mapper;

import org.example.football.model.player.Player;
import org.example.football.model.player.dto.PlayerGetDTO;
import org.example.football.model.player.dto.PlayerPostDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PlayerMapper {
    Player toPlayer(PlayerPostDTO playerPostDTO);
    PlayerGetDTO playerToPlayerGetDTO(Player player);
}
