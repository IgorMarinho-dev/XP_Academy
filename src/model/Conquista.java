package model;

public class Conquista {

    private final String nome;
    private final String descricao;
    private boolean desbloqueada;

    public Conquista(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.desbloqueada = false;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isDesbloqueada() {
        return this.desbloqueada;
    }

    public void desbloquear() {
        this.desbloqueada = true;
    }
}
