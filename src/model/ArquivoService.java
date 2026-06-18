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

            leitor.close();

            String nome = linhaNome.replace("Nome: ", "");
            String email = linhaEmail.replace("Email: ", "");

            int xp = Integer.parseInt(
                    linhaXp.replace("XP: ", "")
            );

            int nivel = Integer.parseInt(
                    linhaNivel.replace("Nivel: ", "")
            );

            Usuario usuario =
                    new Usuario(
                            nome,
                            email,
                            "",
                            xp,
                            nivel
                    );

            return usuario;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}