package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ArquivoService {

    public static void salvarUsuario(Usuario usuario) {

        try {

            FileWriter writer =
                    new FileWriter("usuario.txt");

            writer.write(
                    "Nome: "
                            + usuario.getNome()
                            + "\n"
            );

            writer.write(
                    "Email: "
                            + usuario.getEmail()
                            + "\n"
            );

            writer.write(
                    "XP: "
                            + usuario.getXp()
                            + "\n"
            );

            writer.write(
                    "Nivel: "
                            + usuario.getNivel()
                            + "\n"
            );

            writer.write(
                    "Missoes: "
                            + usuario.getMissoes().size()
                            + "\n"
            );

            for (Missao missao : usuario.getMissoes()) {

                writer.write(
                        missao.getTitulo()
                                + ";"
                                + missao.getCategoria()
                                + ";"
                                + missao.getDificuldade()
                                + ";"
                                + missao.isConcluida()
                                + "\n"
                );

            }

            writer.close();

            System.out.println(
                    "Dados salvos com sucesso!"
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao salvar arquivo."
            );

        }

    }

    public static Usuario carregarUsuario() {

        try {

            BufferedReader leitor =
                    new BufferedReader(
                            new FileReader("usuario.txt")
                    );

            String linhaNome = leitor.readLine();
            String linhaEmail = leitor.readLine();
            String linhaXp = leitor.readLine();
            String linhaNivel = leitor.readLine();
            String linhaMissoes = leitor.readLine();

            String nome = linhaNome.replace("Nome: ", "");
            String email = linhaEmail.replace("Email: ", "");

            int xp = Integer.parseInt(
                    linhaXp.replace("XP: ", "")
            );

            int nivel = Integer.parseInt(
                    linhaNivel.replace("Nivel: ", "")
            );

            int quantidadeMissoes =
                    Integer.parseInt(
                            linhaMissoes.replace("Missoes: ", "")
                    );

            Usuario usuario =
                    new Usuario(
                            nome,
                            email,
                            "",
                            xp,
                            nivel
                    );

            for (int i = 0; i < quantidadeMissoes; i++) {

                String linhaMissao = leitor.readLine();

                String[] dados = linhaMissao.split(";");

                Missao missao = new Missao(
                        dados[0],
                        Integer.parseInt(dados[2]),
                        "",
                        dados[1]
                );

                if (Boolean.parseBoolean(dados[3])) {
                    missao.concluirMissao();
                }

                usuario.adicionarMissao(missao);
            }

            leitor.close();

            return usuario;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}