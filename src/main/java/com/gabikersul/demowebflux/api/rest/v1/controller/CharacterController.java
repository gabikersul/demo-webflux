package com.gabikersul.demowebflux.api.rest.v1.controller;

import com.gabikersul.demowebflux.data.character.client.CharacterClient;
import com.gabikersul.demowebflux.data.character.model.CharacterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/characters")
@AllArgsConstructor
public class CharacterController {

    CharacterClient client;

    @GetMapping("/{id}")
    public Mono<CharacterResponse> findCharacterById (@PathVariable String id) {
        return client.findCharacterById(id);
    }

}