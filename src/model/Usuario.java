import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private List<Missao> missoes;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.missoes = new ArrayList<>();
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
}