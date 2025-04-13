package com.jogorpg.atividadeDesafioJogoRPG.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int level;
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private ClassePersonagem classe;


    private int forcaBase;
    private int defesaBase;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemMagico> itensMagicos = new ArrayList<ItemMagico>();

    public Personagem() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNomeAventureiro() {
        return nomeAventureiro;
    }
    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }
    public ClassePersonagem getClasse() {
        return classe;
    }
    public void setClasse(ClassePersonagem classe) {
        this.classe = classe;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getForcaBase() {
        return forcaBase;
    }
    public void setForcaBase(int forcaBase) {
        this.forcaBase = forcaBase;
    }
    public int getDefesaBase() {
        return defesaBase;
    }
    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }
    public List<ItemMagico> getItensMagicos() {
        return itensMagicos;
    }
    public void setItensMagicos(List<ItemMagico> itensMagicos) {
        this.itensMagicos = itensMagicos;
    }

    public void adicionarItem(ItemMagico item) {
        this.itensMagicos.add(item);
        item.setPersonagem(this);
    }

    public void removerItem(ItemMagico item) {
        this.itensMagicos.remove(item);
        item.setPersonagem(null);
    }

    public int getForcaTotal() {
        int total = forcaBase;
        for (ItemMagico item : itensMagicos) {
            total += item.getForca();
        }
        return total;
    }

    public int getDefesaTotal() {
        int total = defesaBase;
        for (ItemMagico item : itensMagicos) {
            total += item.getDefesa();
        }
        return total;
    }
}
