package br.com.dbc.pokedex.controller;

import br.com.dbc.pokedex.dto.TreinadorCreateDTO;
import br.com.dbc.pokedex.dto.TreinadorDTO;
import br.com.dbc.pokedex.exceptions.RegraDeNegocioException;
import br.com.dbc.pokedex.service.TreinadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/treinador")
@Validated
@RequiredArgsConstructor
public class TreinadorController {
    private final TreinadorService treinadorService;

    @PostMapping
    public TreinadorDTO create(@RequestBody @Valid TreinadorCreateDTO treinadorCreateDTO) {
        TreinadorDTO treinadorDTO = treinadorService.create(treinadorCreateDTO);
        return treinadorDTO;
    }

    @GetMapping
    public List<TreinadorDTO> list() {
        return treinadorService.list();
    }

    @PutMapping("/{idTreinador}")
    public TreinadorDTO update(@PathVariable("idTreinador") String idTreinador,
                               @RequestBody @Valid TreinadorCreateDTO treinadorCreateDTO) throws RegraDeNegocioException {
        TreinadorDTO treinadorDTO = treinadorService.update(idTreinador, treinadorCreateDTO);
        return treinadorDTO;
    }

    @DeleteMapping("/{idTreinador}")
    public void delete(@PathVariable("idTreinador") String idTreinador) throws RegraDeNegocioException {
        treinadorService.delete(idTreinador);
    }
}
