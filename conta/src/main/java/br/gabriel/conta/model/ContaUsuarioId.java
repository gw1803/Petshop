package br.gabriel.conta.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ContaUsuarioId implements Serializable {
    private Long idConta;
    private Long idUsuario;

}
