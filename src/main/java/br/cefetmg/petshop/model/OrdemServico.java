package br.cefetmg.petshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ordem_servico")
public class OrdemServico {

    @EmbeddedId
    private OrdemServicoId id = new OrdemServicoId();

    @ManyToOne
    @MapsId("idOrdem")
    private Ordem ordem;

    @ManyToOne
    @MapsId("idServico")
    private Servico servico;

    @Column(nullable = false)
    private BigDecimal valor;

}
