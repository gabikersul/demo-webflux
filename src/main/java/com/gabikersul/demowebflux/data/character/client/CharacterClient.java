package com.gabikersul.demowebflux.data.character.client;

import com.gabikersul.demowebflux.data.character.model.CharacterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class CharacterClient {

    private final WebClient webClient;

    public CharacterClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build(); //todo: tentar colocar em variavel no app.properties
    }

    public Mono<CharacterResponse> findCharacterById(String id) {
        log.info("Searching Rick and Morty's character by id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Couldn't retrieve Rick and Morty's character.")))
                .bodyToMono(CharacterResponse.class);
    }

}