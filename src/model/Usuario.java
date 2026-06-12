import model.Conquista;

import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private List<Missao> missoes;
    private List<Missao> historicoMissoes;
    private List<Conquista> conquistas;
    private int xp;
    private int nivel;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.missoes = new ArrayList<>();
        this.historicoMissoes = new ArrayList<>();
        this.conquistas = new ArrayList<>();

        this.conquistas.add(
                new Conquista(
                        "Primeira Missão",
                        "Conclua sua primeira missão."
                )
        );

        this.conquistas.add(
                new Conquista(
                        "Veterano",
                        "Conclua 5 missões."
                )
        );

        this.xp = 0;
        this.nivel = 1;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public int getXp() {
        return xp;
    }

    public int getNivel() {
        return nivel;
    }

    public void adicionarMissao(Missao missao) {
        this.missoes.add(missao);
    }

    public List<Missao> getMissoes() {
        return this.missoes;
    }

    public void listarMissoes() {
        for (Missao missao : this.missoes) {
            System.out.println("Título: " + missao.getTitulo());
            System.out.println("Categoria: " + missao.getCategoria());
            System.out.println("Dificuldade: " + missao.getDificuldade());
            System.out.println("Concluída: " + missao.isConcluida());
            System.out.println("---------------------");
        }
    }

    public List<Missao> getHistoricoMissoes() {
        return historicoMissoes;
    }

    public void listarHistoricoMissoes() {

        System.out.println("\n=== HISTÓRICO ===");

        for (Missao missao : this.historicoMissoes) {

            System.out.println(
                    "Título: " + missao.getTitulo()
            );

            System.out.println(
                    "Categoria: " + missao.getCategoria()
            );

            System.out.println(
                    "Dificuldade: " + missao.getDificuldade()
            );

            System.out.println("---------------------");
        }
    }

    public void adicionarConquista(Conquista conquista) {
        this.conquistas.add(conquista);
    }

    public List<Conquista> getConquistas() {
        return this.conquistas;
    }

    public Conquista buscarConquista(String nome) {

        for (Conquista conquista : this.conquistas) {

            if (conquista.getNome().equals(nome)) {
                return conquista;
            }

        }

        return null;
    }

    private void verificarConquistas() {

        Conquista primeiraMissao =
                buscarConquista("Primeira Missão");

        if (primeiraMissao != null &&
                !primeiraMissao.isDesbloqueada() &&
                getQuantidadeMissoesConcluidas() >= 1) {

            primeiraMissao.desbloquear();

            System.out.println(
                    "\nConquista desbloqueada: "
                            + primeiraMissao.getNome()
            );
        }

        Conquista veterano =
                buscarConquista("Veterano");

        if (veterano != null &&
                !veterano.isDesbloqueada() &&
                getQuantidadeMissoesConcluidas() >= 5) {

            veterano.desbloquear();

            System.out.println(
                    "\nConquista desbloqueada: "
                            + veterano.getNome()
            );
        }
    }

    public void ganharXp(int quantidade) {
        int nivelAnterior = this.nivel;

        this.xp += quantidade;
        this.nivel = (this.xp / 100) + 1;

        if (this.nivel > nivelAnterior) {
            System.out.println("Parabéns! Você alcançou o nível " + this.nivel + "!");
        }
    }

    private int calcularXp(Missao missao) {

        switch (missao.getDificuldade()) {

            case 0:
                return 10;

            case 1:
                return 25;

            case 2:
                return 50;

            case 3:
                return 100;

            case 4:
                return 200;

            case 5:
                return 500;

            default:
                return 0;
        }
    }

    public void concluirMissao(Missao missao) {
        if (!missao.isConcluida()) {

            missao.concluirMissao();

            this.historicoMissoes.add(missao);

            int xpRecebido = calcularXp(missao);

            ganharXp(xpRecebido);

            verificarConquistas();

            System.out.println("Missão Concluída!");
            System.out.println("Xp recebido: " + xpRecebido);
        }
    }

    public int getQuantidadeMissoesPendentes() {
        int contador = 0;

        for (Missao missao : this.missoes) {
            if (!missao.isConcluida()) {
                contador++;
            }
        }

        return contador;
    }

    public int getQuantidadeMissoesConcluidas() {
        int contador = 0;

        for (Missao missao : this.missoes) {
            if (missao.isConcluida()) {
                contador++;
            }
        }

        return contador;
    }

    public void mostrarEstatisticas() {

        System.out.println("\n=== ESTATÍSTICAS ===");

        System.out.println("Usuário: " + this.nome);
        System.out.println("XP: " + this.xp);
        System.out.println("Nível: " + this.nivel);

        System.out.println("Missões concluídas: "
                + getQuantidadeMissoesConcluidas());

        System.out.println("Missões pendentes: "
                + getQuantidadeMissoesPendentes());

        System.out.println("====================\n");
    }
}