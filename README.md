
# 📘 Documentação da API - Sistema de Gerenciamento de RPG

Este projeto é um sistema de gerenciamento para um jogo de RPG. Ele permite o cadastro de personagens e seus respectivos itens mágicos, com regras específicas para força, defesa e tipos de itens.

---

## 🔗 Endpoints Disponíveis

### ✅ 1. Cadastrar Personagem
- **Método:** `POST`
- **URL:** `/personagens`
- **Descrição:** Cria um novo personagem com até 10 pontos distribuídos entre força e defesa.
- **Body Exemplo (JSON):**
```json
{
  "nome": "João",
  "nomeAventureiro": "João, o Brabo",
  "classe": "Guerreiro",
  "level": 1,
  "forcaBase": 6,
  "defesaBase": 4
}
```

---

### ✅ 2. Cadastrar Item Mágico
- **Método:** `POST`
- **URL:** `/itens`
- **Descrição:** Cria um novo item mágico.
- **Body Exemplo (JSON):**
```json
{
  "nome": "Espada Flamejante",
  "tipo": "Arma",
  "forca": 5,
  "defesa": 0
}
```

---

### ✅ 3. Listar Todos os Personagens
- **Método:** `GET`
- **URL:** `/personagens`
- **Descrição:** Retorna a lista de todos os personagens cadastrados.

---

### ✅ 4. Buscar Personagem por Identificador
- **Método:** `GET`
- **URL:** `/personagens/{id}`
- **Descrição:** Retorna os dados do personagem com o ID informado.

---

### ✅ 5. Atualizar Nome Aventureiro por Identificador
- **Método:** `PATCH`
- **URL:** `/personagens/{id}/nome-aventureiro`
- **Descrição:** Atualiza apenas o nome aventureiro de um personagem.
- **Body Exemplo (JSON):**
```json
{
  "nomeAventureiro": "João, o Destemido"
}
```

---

### ✅ 6. Remover Personagem
- **Método:** `DELETE`
- **URL:** `/personagens/{id}`
- **Descrição:** Remove um personagem e todos os seus itens mágicos.

---

### ✅ 7. Listar Todos os Itens Mágicos
- **Método:** `GET`
- **URL:** `/itens`
- **Descrição:** Retorna a lista de todos os itens mágicos cadastrados.

---

### ✅ 8. Buscar Item Mágico por Identificador
- **Método:** `GET`
- **URL:** `/itens/{id}`
- **Descrição:** Retorna os dados de um item mágico pelo seu ID.

---

### ✅ 9. Adicionar Item Mágico a um Personagem
- **Método:** `POST`
- **URL:** `/personagens/{personagemId}/itens/{itemId}`
- **Descrição:** Associa um item mágico já existente a um personagem, respeitando as regras de tipos.

---

### ✅ 10. Listar Itens Mágicos de um Personagem
- **Método:** `GET`
- **URL:** `/personagens/{personagemId}/itens`
- **Descrição:** Lista todos os itens mágicos pertencentes a um personagem.

---

### ✅ 11. Remover Item Mágico do Personagem
- **Método:** `DELETE`
- **URL:** `/personagens/{personagemId}/itens/{itemId}`
- **Descrição:** Remove um item mágico do personagem, mas o item ainda permanece no sistema.

---

### ✅ 12. Buscar Amuleto do Personagem
- **Método:** `GET`
- **URL:** `/personagens/{personagemId}/amuleto`
- **Descrição:** Retorna o item do tipo **Amuleto** vinculado ao personagem, caso exista.

---

## 📌 Observações Importantes

- A soma de `forcaBase` e `defesaBase` de um personagem não pode ultrapassar **10 pontos**.
- Os tipos de item mágico permitidos são: **Arma**, **Armadura**, e **Amuleto**.
- Um personagem só pode ter **1 Amuleto**.
- Itens do tipo **Arma** devem ter **defesa = 0**.
- Itens do tipo **Armadura** devem ter **força = 0**.
- Itens não podem ter **força = 0** e **defesa = 0** ao mesmo tempo.
