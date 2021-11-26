package br.com.dbc.pokedex.service;

import br.com.dbc.pokedex.client.PokeProjetoClient;
import br.com.dbc.pokedex.dto.LoginDTO;
import br.com.dbc.pokedex.dto.PokedexDTO;
import br.com.dbc.pokedex.dto.TreinadorCreateDTO;
import br.com.dbc.pokedex.dto.TreinadorDTO;
import br.com.dbc.pokedex.entity.PokedexEntity;
import br.com.dbc.pokedex.entity.TreinadorEntity;
import br.com.dbc.pokedex.exceptions.RegraDeNegocioException;
import br.com.dbc.pokedex.repository.PokedexRepository;
import br.com.dbc.pokedex.repository.TreinadorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PokedexService {
    private final PokeProjetoClient pokeProjetoClient;
    private final ObjectMapper objectMapper;
    private final PokedexRepository pokedexRepository;
    private final TreinadorService treinadorService;
    private final TreinadorRepository treinadorRepository;

    public String auth(LoginDTO loginDTO) {
        return pokeProjetoClient.auth(loginDTO);
    }

    public List<Document> listPokeDados(String authorizationHeader) {
        return pokeProjetoClient.listPokeDados(authorizationHeader);
    }

    public Integer countTotalPokemons(String authorizationHeader) {
        List<Document> pokemons = listPokeDados(authorizationHeader);
        return pokemons.size();
    }

    public PokedexDTO create(String auth, String idTreinador) throws RegraDeNegocioException {
        PokedexEntity entity = new PokedexEntity();
        List<Document> pokemons = new ArrayList<>();
        for (int i = 0; i < countTotalPokemons(auth); i++) {
            pokemons.add(new Document("numero", i));
        }

        entity.setPokemons(pokemons);
        PokedexEntity create = pokedexRepository.save(entity);
        TreinadorEntity treinadorEntity = treinadorService.getEntityById(idTreinador);
        treinadorEntity.setPokedexEntity(create);
        TreinadorEntity update = treinadorRepository.save(treinadorEntity);
        PokedexDTO pokedexDTO = objectMapper.convertValue(create, PokedexDTO.class);
        return pokedexDTO;
    }
}
