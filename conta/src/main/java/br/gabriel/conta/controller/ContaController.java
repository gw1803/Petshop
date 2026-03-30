package br.gabriel.conta.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gabriel.conta.model.Conta;
import br.gabriel.conta.service.ContaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/contas")
@RequiredArgsConstructor
public class ContaController {

    public final ContaService contaService;

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getConta(@PathVariable Long id){
        Conta conta = contaService.getConta(id);
        return ResponseEntity.ok().body(conta);
    }

    @GetMapping("")
    public ResponseEntity<List<Conta>> getContaList(){
        return ResponseEntity.ok().body(contaService.getContaList());
    }

    @PostMapping("")
    public ResponseEntity<Conta> insertConta(@RequestBody Conta conta){
        Conta contaAux = contaService.insertConta(conta);
        return ResponseEntity.ok().body(contaAux);
    }

    @PutMapping("")
    public ResponseEntity<Conta> updateConta(@RequestBody Conta conta){
        Conta contaAux = contaService.updateConta(conta);
        return ResponseEntity.ok().body(contaAux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> deleteConta(@PathVariable Long id){
        Conta contaAux = contaService.deleteConta(id);
        return ResponseEntity.ok().body(contaAux);
    }
}
