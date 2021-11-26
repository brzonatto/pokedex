package br.com.dbc.pokedex.client;

import br.com.dbc.pokedex.dto.LoginDTO;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "poke-projeto", url = "https://poke-projeto-vemser.herokuapp.com")
@Headers("Content-Type: application/json")
public interface PokeProjetoClient {

    @RequestLine("POST /auth")
    String auth(LoginDTO loginDTO);




}
