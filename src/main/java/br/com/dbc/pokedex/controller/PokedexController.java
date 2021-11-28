package br.com.dbc.pokedex.controller;

import br.com.dbc.pokedex.dto.*;
import br.com.dbc.pokedex.entity.PokedexEntity;
import br.com.dbc.pokedex.exceptions.RegraDeNegocioException;
import br.com.dbc.pokedex.service.PokedexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pokedex")
@Validated
@RequiredArgsConstructor
@Slf4j
public class PokedexController {
    private final PokedexService pokedexService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {
        return pokedexService.auth(loginDTO);
    }

    @PostMapping("/create")
    public PokedexDTO create(@RequestHeader("Authorization") String authorizationHeader, @RequestParam("idTreinador") String idTreinador) throws RegraDeNegocioException {
        return pokedexService.create(authorizationHeader, idTreinador);
    }

    @PutMapping
    public PokedexEntity revelarPokemon( @RequestParam("numeroPokemon") Integer numeroPokemon,
                                         @RequestParam("idTreinador") String idTreinador,
                                         @RequestHeader("Authorization") String authorizationHeader)
            throws RegraDeNegocioException {
        return pokedexService.revelarPokemon(numeroPokemon, idTreinador, authorizationHeader);
    }

    @GetMapping("/dados/pokedex")
    public PokedexDadosDTO getDadosPokedex(@RequestParam String idTreinador, @RequestHeader("Authorization") String authorizationHeader) throws RegraDeNegocioException {
        return pokedexService.getDadosPokedex(idTreinador, authorizationHeader);
    }
}
