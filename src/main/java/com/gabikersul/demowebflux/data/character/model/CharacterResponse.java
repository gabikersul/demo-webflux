package com.gabikersul.demowebflux.data.character.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) //qual a visibilidade p/ ver os valores dos campos
public class CharacterResponse {

    private int id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;

}