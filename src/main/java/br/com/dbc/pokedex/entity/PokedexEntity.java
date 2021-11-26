package br.com.dbc.pokedex.entity;

import lombok.*;
import org.bson.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document
public class PokedexEntity {

    @Id
    private String idPokedex;

    private List<Document> pokemons;
}
