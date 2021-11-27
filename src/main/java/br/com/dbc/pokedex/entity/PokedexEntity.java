package br.com.dbc.pokedex.entity;

import br.com.dbc.pokedex.dto.PokeDadosDTO;
import lombok.*;
import org.bson.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document(collection = "pokedex")
public class PokedexEntity {
    @Id
    private String idPokedex;
    private Integer quantidadeDePokemonsExistentes;
    private Integer quantidadePokemonsRevelados;
    private List<PokeDadosDTO> pokemons;
}
