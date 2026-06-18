package model;

public class Missao {

    private String titulo;
    private int dificuldade;
    private String descricao;
    private String categoria;
    private boolean concluida;

    public Missao(String titulo, int dificuldade, String descricao, String categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.concluida = false;

        setDificuldade(dificuldade);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setDificuldade(int dificuldade) {
        if (dificuldade < 0 || dificuldade > 5) {
            throw new IllegalArgumentException(
                "A dificuldade deve ser entre 0 e 5."
            );
        }

        this.dificuldade = dificuldade;
    }

    public int getDificuldade() {
        return this.dificuldade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public boolean isConcluida() {
        return this.concluida;
    }

    public void concluirMissao() {
        this.concluida = true;
    }

    public void reabrirMissao() {
        this.concluida = false;
    }
}