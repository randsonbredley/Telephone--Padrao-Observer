# Padrões de Projeto - Exercício 2: Observer (Telefone)

Este repositório contém a solução para a prática do padrão de projeto **Observer** aplicada ao sistema simulador de **Telefone**, referente à Lista Avaliativa I da disciplina de Padrões de Projetos Orientados a Objetos (IFPE Campus Belo Jardim).

---

## 📌 Visão Geral da Solução

O objetivo desta atividade é desacoplar o modelo de dados do telefone (`PhoneModel`) da interface de usuário (`Screen`), de modo que:
- Apenas a classe `Screen` realize impressões na tela.
- O `PhoneModel` não possua referências diretas para a `Screen`, comunicando-se exclusivamente através da interface abstrata `PhoneObserver`.

Dois observadores foram registrados na interface do usuário:
1. **Primeiro Observador:** Notifica e imprime no console cada dígito assim que é pressionado.
2. **Segundo Observador:** Acumula os dígitos inseridos e exibe a mensagem `"Agora discando <numero>..."` assim que a discagem atinge a quantidade esperada de dígitos.

---

## 🛠️ Padrão Observer Aplicado

```
+------------------+         notifica          +-------------------+
|   PhoneModel     | ------------------------> |   PhoneObserver   |
+------------------+                           +-------------------+
| - observers      |                                     ^
| + addObserver()  |                                     | implementa
| + notify()       |                           +-------------------+
+------------------+                           |  Screen (UI)      |
                                               +-------------------+
```

---

## 📜 Histórico de Commits e Evolução (Passo a Passo)

A evolução da solução foi totalmente documentada por meio do histórico de commits abaixo:

### Commit 1
- **Mensagem:** `Adiciona interface PhoneObserver`
- **Descrição/Prompt:** Solicitação para criar a interface do observador definindo a assinatura do método de notificação.
- **Ajustes e Justificativa:** Foi definido o método `void digitAdded(int digit)`. O parâmetro traz o novo dígito individual, mas caso o observador precise de todo o histórico, ele pode consultar `PhoneModel.getDigits()`.

### Commit 2
- **Mensagem:** `PhoneModel passa a suportar e notificar observadores`
- **Descrição/Prompt:** Atualização da classe `PhoneModel` para gerenciar a lista de observadores e disparar notificações ao inserir novos dígitos.
- **Ajustes e Justificativa:** Garantido o desacoplamento. `PhoneModel` não importa `Screen` nem utiliza `System.out.println`, mantendo a regra de que a regra de negócio não depende da UI.

### Commit 3
- **Mensagem:** `Screen cria e registra os dois observadores`
- **Descrição/Prompt:** Implementação das duas lógicas de observadores dentro de `Screen`.
- **Ajustes e Justificativa:** As lógicas de exibição foram encapsuladas em `Screen` por meio de classes anônimas/lambdas. O segundo observador utiliza `StringBuilder` para concatenar a lista de inteiros trazida pelo modelo e adiciona o sufixo `"..."`.

### Commit 4
- **Mensagem:** `Ajusta idioma das mensagens no KeyPad para PT-BR e valida fluxo`
- **Descrição/Prompt:** Testar e ajustar as mensagens do `KeyPad`.
- **Ajustes e Justificativa:** Corrigida a string no `KeyPad` de `"Pressing: "` para `"Pressionando: "`, adequando o console exatamente ao exemplo fornecido no enunciado em Português.

### Commit 5
- **Mensagem:** `Dispara mensagem de discagem apenas ao completar todos os dígitos`
- **Descrição/Prompt:** Ajuste na regra de exibição da discagem completa.
- **Ajustes e Justificativa:** Adicionada verificação no segundo observador para checar se `model.getDigits().size()` atingiu a quantidade total esperada (12 dígitos) antes de imprimir a string final `"Agora discando..."`.

---

## 🚀 Como Executar

1. Compile os arquivos Java no pacote `telephone`:
   ```bash
   javac telephone/*.java
   ```
2. Execute a classe principal:
   ```bash
   java telephone.Main
   ```
