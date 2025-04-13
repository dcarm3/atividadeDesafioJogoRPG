package com.jogorpg.atividadeDesafioJogoRPG.service;

import com.jogorpg.atividadeDesafioJogoRPG.entity.Personagem;
import com.jogorpg.atividadeDesafioJogoRPG.repository.PersonagemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criarPersonagem(Personagem personagem) {
        int total = personagem.getForcaBase() + personagem.getDefesaBase();
        if (total > 10) {
            throw new RuntimeException("A soma de Força e Defesa base não pode ultrapassar 10.");
        }
        return personagemRepository.save(personagem);
    }

    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    public Personagem buscarPorId(Long id) {
        Optional<Personagem> p = personagemRepository.findById(id);
        if (!p.isPresent()){
            throw new RuntimeException("Personagem não encontrado com ID: " + id);
        }
        return p.get();
    }

    public Personagem atualizarNomeAventureiro(Long id, String nomeAventureiro) {
        Personagem personagem = buscarPorId(id);
        personagem.setNomeAventureiro(nomeAventureiro);
        return personagemRepository.save(personagem);
    }

    public void removerPersonagem(Long id) {
        Personagem personagem = buscarPorId(id);
        personagemRepository.delete(personagem);
    }
}
