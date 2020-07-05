package Classes;

import java.io.Serializable;

public abstract class Correntista implements Serializable{

    private static int proximoCod = 1;
    
    private int codigo;
    private String nome;
    private Conta conta;

    public Correntista(String nome, Conta conta) {
        this.codigo = getProximoCod();
        this.nome = nome;
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public static int getProximoCod(){
        return proximoCod++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static void imprimeSaudacoes(){
        System.out.println("Óla Correntista!");
    }
    
    public abstract void exibeDetalhes();
}
