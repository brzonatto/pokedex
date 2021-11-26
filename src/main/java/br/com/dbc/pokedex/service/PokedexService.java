package br.com.dbc.pokedex.service;

import br.com.dbc.pokedex.client.PokeProjetoClient;
import br.com.dbc.pokedex.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class PokedexService {
    private final PokeProjetoClient pokeProjetoClient;

    public String auth(LoginDTO loginDTO) {
        return pokeProjetoClient.auth(loginDTO);
    }

    public List<Document> listPokeDados(String authorizationHeader) {
        return pokeProjetoClient.listPokeDados(authorizationHeader);
    }
}
