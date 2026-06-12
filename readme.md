# XP Academy

XP Academy é um projeto pessoal desenvolvido em Java com o objetivo de transformar metas e tarefas do dia a dia em um sistema inspirado em RPGs.

A proposta é permitir que usuários criem missões personalizadas, organizem seus objetivos e acompanhem seu progresso através de mecânicas de evolução e progressão.

## Objetivo do Projeto

O XP Academy nasceu como um projeto de estudo e prática de desenvolvimento de software, servindo tanto para aprendizado de Java quanto para a criação de uma ferramenta útil para produtividade pessoal.

A ideia principal é transformar tarefas comuns em missões, incentivando a conclusão de objetivos através de sistemas de progressão inspirados em jogos.

## Tecnologias

### Back-End

* Java

### Banco de Dados (Planejado)

* MySQL

### Front-End (Planejado)

* HTML
* CSS
* JavaScript

## Funcionalidades da Versão 0.3

### Usuários

* Criação de usuários
* Armazenamento de informações básicas
* Sistema de XP
* Sistema de níveis
* Exibição de estatísticas do usuário

### Missões

* Criação de missões
* Definição de dificuldade (0 a 5)
* Descrição personalizada
* Categoria personalizada
* Status de conclusão

### Gerenciamento

* Associação de missões a usuários
* Listagem de missões
* Histórico de missões concluídas
* Conclusão de missões
* Contagem de missões concluídas
* Contagem de missões pendentes

### Progressão

* Ganho de XP ao concluir missões
* Recompensa baseada na dificuldade da missão
* Sistema automático de subida de nível
* Mensagem de evolução ao subir de nível

### Conquistas

* Sistema de conquistas desbloqueáveis
* Verificação automática de conquistas
* Conquista "Primeira Missão"
* Conquista "Veterano"
* Desbloqueio único por conquista
* Associação de conquistas ao usuário

## Estrutura Atual

* `Usuario.java`

  * Responsável por armazenar informações do usuário, missões, histórico de missões, XP, nível e conquistas.

* `Missao.java`

  * Representa uma missão criada pelo usuário, incluindo título, descrição, dificuldade, categoria e status de conclusão.

* `Conquista.java`

  * Representa uma conquista desbloqueável pelo usuário.

* `Main.java`

  * Utilizado para testes e execução das funcionalidades atuais.

## Histórico de Versões

### v0.1

* Sistema básico de usuários
* Sistema de missões
* Associação de missões ao usuário

### v0.2

* Sistema de XP
* Sistema de níveis
* Recompensas por dificuldade
* Estatísticas do usuário

### v0.3 (Em desenvolvimento)

* ✔ Sistema de conquistas
* ✔ Primeira Missão
* ✔ Veterano
* ✔ Categorias de missões
* ✔ Histórico de missões
* ⬜ Estatísticas avançadas

## Roadmap

### Versão 0.4

* Salvamento de progresso em arquivo
* Persistência de dados entre execuções
* Carregamento automático do perfil do usuário

### Versão 0.5

* Integração com banco de dados MySQL
* Camada de serviços e repositórios
* Estrutura preparada para aplicação web

### Versão 1.0

* Interface web
* Sistema de autenticação
* Persistência completa de dados
* Dashboard do usuário
* Sistema completo de progressão

## Autor

Desenvolvido por Igor Marinho como projeto de aprendizado, prática de programação orientada a objetos e construção de portfólio.
