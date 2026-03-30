package br.gabriel.conta.model;

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
@Entity(name = "conta_usuario")
public class ContaUsuario {

    @EmbeddedId
    private ContaUsuarioId id = new ContaUsuarioId();

    @ManyToOne
    @MapsId("idConta")
    private Conta conta;

    @ManyToOne
    @MapsId("idUsuario")
    private Usuario usuario;

    @Column(nullable = true)
    private BigDecimal valor;

    @Column(nullable = true)
    private BigDecimal qntdGasta;

}
