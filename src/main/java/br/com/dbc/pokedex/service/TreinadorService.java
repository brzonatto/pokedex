package br.com.dbc.pokedex.service;

import br.com.dbc.pokedex.dto.TreinadorCreateDTO;
import br.com.dbc.pokedex.entity.PokedexEntity;
import br.com.dbc.pokedex.exceptions.RegraDeNegocioException;
import br.com.dbc.pokedex.dto.TreinadorDTO;
import br.com.dbc.pokedex.entity.TreinadorEntity;
import br.com.dbc.pokedex.repository.TreinadorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreinadorService {
    private final TreinadorRepository treinadorRepository;
    private final ObjectMapper objectMapper;

    public TreinadorDTO create(TreinadorCreateDTO treinadorCreateDTO, String auth) {
        TreinadorEntity entity = objectMapper.convertValue(treinadorCreateDTO, TreinadorEntity.class);
        TreinadorEntity create = treinadorRepository.save(entity);
        TreinadorDTO treinadorDTO = objectMapper.convertValue(create, TreinadorDTO.class);
        return treinadorDTO;
    }

    public List<TreinadorDTO> list() {
        return treinadorRepository.findAll()
                .stream()
                .map(treinador -> objectMapper.convertValue(treinador, TreinadorDTO.class))
                .collect(Collectors.toList());
    }

    public TreinadorDTO update(String idTreinador, TreinadorCreateDTO treinadorCreateDTO) throws RegraDeNegocioException {
        TreinadorEntity entity = getEntityById(idTreinador);
        entity.setNomeCompleto(treinadorCreateDTO.getNomeCompleto());
        entity.setDataNascimento(treinadorCreateDTO.getDataNascimento());
        entity.setSexo(treinadorCreateDTO.getSexo());
        entity.setEmail(treinadorCreateDTO.getEmail());
        TreinadorEntity update = treinadorRepository.save(entity);
        TreinadorDTO treinadorDTO = objectMapper.convertValue(update, TreinadorDTO.class);
        return treinadorDTO;
    }

    public void delete(String idTreinador) throws RegraDeNegocioException {
        treinadorRepository.delete(getEntityById(idTreinador));
    }

    public TreinadorEntity getEntityById(String idTreinador) throws RegraDeNegocioException {
        return treinadorRepository.findById(idTreinador)
                .orElseThrow(() -> new RegraDeNegocioException("Treinador não encontrado"));
    }

    public void revelarPokemon() {

    }
}
