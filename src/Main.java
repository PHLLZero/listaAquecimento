import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Persistencia persistencia = new Persistencia();
        String nomeArquivo = "central.xml";

        CentralDeInformacoes central = = persistencia.recuperarCentral(nomeArquivo);

        String op = "";

        while (!op.equals("S")){

            System.out.println("\n=== MENU CENTRAL DE INFORMAÇÕES ===");
            System.out.println("1 - Novo jogador");
            System.out.println("2 - Listar todos os jogadores");
            System.out.println("3 - Exibir informações de um jogador específico");
            System.out.println("S - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextLine();

            switch (op){
                case "1":
                    System.out.println("\n-*- Novo Jogador -*-\n");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    System.out.print("Sexo (M/F): ");
                    String sexoInput = sc.nextLine();

                    Sexo sexo;
                    if (sexoInput.equals("M")) {
                        sexo = Sexo.MASCULINO;
                    } else {
                        sexo = Sexo.FEMININO;
                    }

                    Jogador novoJogador = new Jogador(nome, sexo, cpf, email);

                    boolean adc = central.adicionarJogador(novoJogador);

                    if (adc) {
                        persistencia.salvarCentral(central, nomeArquivo);
                    }

                    break;


                case "2":
                    System.out.println("\n-*- Lista de Jogadores -*-\n");
                    ArrayList<Jogador> jogadores = central.getTodosOsJogadores();

                    if (jogadores.isEmpty()) {
                        System.out.println("Nenhum jogador cadastrado.");
                    } else {
                        for (Jogador j : jogadores) {
                            System.out.println("Nome: " + j.getNome() + " | CPF: " + j.getCPF() + " | Email: " + j.getEmail());
                        }
                    }

                    break;


                case "3":
                    System.out.println("\n-*- Exibir Jogador Específico -*-\n");
                    System.out.print("Digite o CPF do jogador: ");
                    String cpfBusca = sc.nextLine();

                    Jogador jogadorEncontrado = central.recuperarJogadorPorCPF(cpfBusca);

                    if (jogadorEncontrado != null) {
                        System.out.println("\nJogador Encontrado:");
                        System.out.println("Nome: " + jogadorEncontrado.getNome());
                        System.out.println("CPF: " + jogadorEncontrado.getCPF());
                        System.out.println("E-mail: " + jogadorEncontrado.getEmail());
                        System.out.println("Sexo: " + jogadorEncontrado.getSexo());
                    } else {
                        System.out.println("Nenhum jogador encontrado com o CPF informado.");
                    }
                    break;

                case "S":
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;

            }

        }



    }
}
