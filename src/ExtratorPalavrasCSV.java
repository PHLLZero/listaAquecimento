import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ExtratorPalavrasCSV {

    public static ArrayList<Palavra> extrairPalavras(String nomeArquivo){
        ArrayList<Palavra> listaPalavras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;

            while ((linha = br.readLine()) != null){
                String[] partes = linha.split(",");

                if (partes.length != 3){
                    return null;    // criar exception que captura o erro do tamanho (se possivel qual a linha) e retorna no console ou log
                }

                String termo = partes[0].trim();

                int codigoDificuldade = Integer.parseInt((partes[1].trim()));

                String dica = partes[2].trim();

                Dificuldade dif = Dificuldade.deCodigo((codigoDificuldade));        // Trava lingua kkkkk
                                                                                    // O que faz: tenta converter o int recebido em uma das opções la no enum

                if (dif == null){
                    return null;
                }

                Palavra p = new Palavra(termo, dif, dica);      // Alterei a ordem dos atributos no costrutor só pra ficar igual a ordem do CSV
                listaPalavras.add(p);


            }
        } catch (Exception e){      //     <----------- ALTERAR DEPOIS
            return null;
        }
        return listaPalavras;
    }

}
