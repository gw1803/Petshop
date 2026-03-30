package br.gabriel.conta.model;

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
public class Conta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", length = 20, nullable = false, unique = false)
    private String titulo;

    @Column(name = "tipo", length = 20, nullable = false, unique = false)
    private String tipo;

    @Column(name = "valorTotal", length = 20, nullable = false, unique = false)
    private double valorTotal;

    @ManyToMany
    @JoinTable(name = "conta_usuario", joinColumns = { @JoinColumn(name = "conta_id") }, inverseJoinColumns = {
            @JoinColumn(name = "usuario_id") })
    private List<Usuario> usuarios = new ArrayList<>();
}
