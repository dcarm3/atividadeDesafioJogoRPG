package com.jogorpg.atividadeDesafioJogoRPG.controller;


import com.jogorpg.atividadeDesafioJogoRPG.entity.Personagem;
import com.jogorpg.atividadeDesafioJogoRPG.service.PersonagemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public Personagem cadastrar(@RequestBody Personagem personagem) {
        return personagemService.criarPersonagem(personagem);
    }

    @GetMapping
    public List<Personagem> listar() {
        return personagemService.listarTodos();
    }

    @GetMapping("/{id}")
    public Personagem buscarPorId(@PathVariable Long id) {
        return personagemService.buscarPorId(id);
    }

    @PatchMapping("/{id}/nome-aventureiro")
    public Personagem atualizarNomeAventureiro(@PathVariable Long id, @RequestBody String nomeAventureiro) {
        return personagemService.atualizarNomeAventureiro(id, nomeAventureiro);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        personagemService.removerPersonagem(id);
    }
}

