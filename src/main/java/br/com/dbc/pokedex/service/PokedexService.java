package br.com.dbc.pokedex.service;

import br.com.dbc.pokedex.client.PokeProjetoClient;
import br.com.dbc.pokedex.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokedexService {

    private final PokeProjetoClient pokeProjetoClient;

    public String auth(LoginDTO loginDTO) {
        try{
            return pokeProjetoClient.auth(loginDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
