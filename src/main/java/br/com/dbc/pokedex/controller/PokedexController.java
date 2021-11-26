package br.com.dbc.pokedex.controller;

import br.com.dbc.pokedex.dto.LoginDTO;
import br.com.dbc.pokedex.dto.PokedexDTO;
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

    @GetMapping
    public List<Document> listPokeDados(@RequestHeader("Authorization") String authorizationHeader) {
        return pokedexService.listPokeDados(authorizationHeader);
    }

    @GetMapping("/count-total")
    public Integer countTotalPokemons(@RequestHeader("Authorization") String authorizationHeader) {
        return pokedexService.countTotalPokemons(authorizationHeader);
    }

    @PostMapping("/create")
    public PokedexDTO create(@RequestHeader("Authorization") String authorizationHeader, @RequestParam String idTreinador) throws RegraDeNegocioException {
        return pokedexService.create(authorizationHeader, idTreinador);
    }
}
