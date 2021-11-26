package br.com.dbc.pokedex.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class TreinadorEntity {
    @Id
    private String idTreinador;
    private String nomeCompleto;
    private Date dataNascimento;
    private String sexo;
    private String email;
}
