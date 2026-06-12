import model.Conquista;

public class Main {

    public static void main(String[] args) {
        Usuario igor = new Usuario("Igor", "igor@email.com", "123456");

        Missao estudarJava = new Missao("Estudar Java", 2, "Revisar Orientação a Objetos", "Estudo");
        Missao organizarMesa = new Missao("Organizar Mesa", 0, "Organizar a Mesa do Quarto", "Organização");
        Missao programarProjeto = new Missao("Programar Projeto", 3, "Realizar a programação do projeto", "Trabalho");

        igor.adicionarMissao(estudarJava);
        igor.adicionarMissao(organizarMesa);
        igor.adicionarMissao(programarProjeto);

        igor.listarMissoes();
        System.out.println("\nConcluindo missão...\n");

        igor.concluirMissao(programarProjeto);
        igor.listarMissoes();

        System.out.println("XP: " + igor.getXp());
        System.out.println("Nível: " + igor.getNivel());

        igor.ganharXp(150);

        System.out.println("XP: " + igor.getXp());
        System.out.println("Nível: " + igor.getNivel());

        igor.mostrarEstatisticas();

        Conquista primeiraMissao = new Conquista(
                "Primeira Missão",
                "Conclua sua primeira missão."
        );

        System.out.println(primeiraMissao.isDesbloqueada());

        primeiraMissao.desbloquear();

        System.out.println(primeiraMissao.isDesbloqueada());

        Conquista conquista =
                igor.buscarConquista("Primeira Missão");

        System.out.println(conquista.getNome());
    }
}