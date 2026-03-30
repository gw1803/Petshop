package br.gabriel.conta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gabriel.conta.model.Conta;
import br.gabriel.conta.repository.ContaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public Conta getConta(Long id){
        Conta conta = contaRepository.findById(id).orElse(null);
        if (conta == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Informação não encontrada.");
        }
        return conta;
    }

    public List<Conta> getContaList(){
        return contaRepository.findAll();
    }

    public Conta insertConta(Conta conta){
        conta.setId(null);
        contaRepository.save(conta);
        return conta;
    }

    public Conta updateConta(Conta conta){
        if (conta.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id é obrigatório.");
        }
        contaRepository.save(conta);
        return conta;
    }

    public Conta deleteConta(Long id){
        Conta conta = this.getConta(id);
        if (conta == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado um conta com o id: " + id);
        }

        contaRepository.deleteById(id);

        return conta;
    }

}
