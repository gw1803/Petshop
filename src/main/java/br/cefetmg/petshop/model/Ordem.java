package br.cefetmg.petshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private Instant dtOrdem;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_pet", nullable = false, foreignKey = @ForeignKey(name = "fk_ordemservico_pet"))
    private Pet pet;

    @ManyToMany
    @JoinTable(name = "ordem_servico", joinColumns = { @JoinColumn(name = "ordem_id") }, inverseJoinColumns = {
            @JoinColumn(name = "servico_id") })
    private List<Servico> servicos = new ArrayList<>();
}
