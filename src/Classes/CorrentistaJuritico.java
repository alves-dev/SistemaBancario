package Classes;

public class CorrentistaJuritico extends Correntista{


    private String nomeResponsavel;
            

    public CorrentistaJuritico(String nome, String nomeResponsavel, ContaJuridica conta) {
        super(nome, conta);
        this.nomeResponsavel = nomeResponsavel;
    }
    
   

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    
    
    public void exibeDetalhes(){
        System.out.println("Eu sou um Correntista Juridico: " + getCodigo() + " - " + getNome() + " \\ Responsavél: " + getNomeResponsavel());
    }
    
    
}
