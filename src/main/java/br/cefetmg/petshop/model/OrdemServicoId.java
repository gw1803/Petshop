package br.cefetmg.petshop.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrdemServicoId implements Serializable {
    private Long idOrdem;
    private Long idServico;

}
