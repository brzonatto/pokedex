package br.com.dbc.pokedex.controller;

import br.com.dbc.pokedex.dto.LoginDTO;
import br.com.dbc.pokedex.service.PokedexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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


}
