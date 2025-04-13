package com.jogorpg.atividadeDesafioJogoRPG.controller;

import com.jogorpg.atividadeDesafioJogoRPG.entity.ItemMagico;
import com.jogorpg.atividadeDesafioJogoRPG.service.ItemMagicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping("/personagem/{personagemId}")
    public ItemMagico adicionarAoPersonagem(@PathVariable Long personagemId, @RequestBody ItemMagico item) {
        return itemMagicoService.adicionarItemAoPersonagem(personagemId, item);
    }

    @GetMapping
    public List<ItemMagico> listarTodos() {
        return itemMagicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ItemMagico buscarPorId(@PathVariable Long id) {
        return itemMagicoService.buscarPorId(id);
    }

    @GetMapping("/personagem/{personagemId}")
    public List<ItemMagico> listarPorPersonagem(@PathVariable Long personagemId) {
        return itemMagicoService.listarPorPersonagem(personagemId);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        itemMagicoService.remover(id);
    }

    @GetMapping("/personagem/{personagemId}/amuleto")
    public ItemMagico buscarAmuleto(@PathVariable Long personagemId) {
        return itemMagicoService.buscarAmuleto(personagemId);
    }
}

