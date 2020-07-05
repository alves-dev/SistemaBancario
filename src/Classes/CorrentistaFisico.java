package Classes;

public class CorrentistaFisico extends Correntista{
    
     public CorrentistaFisico(String nome, ContaFisica conta) {
        super(nome, conta);
    }
     
     public void exibeDetalhes(){
        System.out.println("Eu sou um Correntista Fisico: " + getCodigo() + " - " + getNome());
    }
    
}
