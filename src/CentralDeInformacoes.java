import java.util.ArrayList;

public class CentralDeInformacoes {

    private ArrayList<Jogador> todosOsJogadores = new ArrayList<Jogador>();

    public boolean adicionarJogador(Jogador j){
        if(recuperarJogadorPorCPF(j.getCPF()) != null || recuperarJogadorPeloEmail(j.getEmail()) != null){
            System.out.println("Jogador já cadastrado!");
            return false;

        }
        todosOsJogadores.add(j);
        System.out.println("Jogador adicionado com sucesso!");
        return true;
    }

    public Jogador recuperarJogadorPorCPF(String CPF){
        for(Jogador j: todosOsJogadores){
            if(j.getCPF().equals(CPF)){
                return j;
            }
        }
        return null;
    }

    public Jogador recuperarJogadorPeloEmail(String email){
        for(Jogador j: todosOsJogadores){
            if(j.getEmail().equals(email)){
                return j;
            }
        }
        return null;
    }

    public ArrayList<Jogador> getTodosOsJogadores() {
        return todosOsJogadores;
    }

    public void setTodosOsJogadores(ArrayList<Jogador> todosOsJogadores) {
        this.todosOsJogadores = todosOsJogadores;
    }
}
