import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private List<Missao> missoes;
    private int xp;
    private int nivel;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.missoes = new ArrayList<>();

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
            System.out.println("Dificuldade: " + missao.getDificuldade());
            System.out.println("Concluída: " + missao.isConcluida());
            System.out.println("---------------------");
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

            int xpRecebido = calcularXp(missao);

            ganharXp(xpRecebido);

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