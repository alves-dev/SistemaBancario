package Classes;

public class ContaJuridica implements Conta {

    private double saldo = 0.0;

    //taxa de juros
    private static final double I = 0.05;

    @Override
    public void extrato() {
        System.out.println("Saldo da conta juridica: " + saldo);
    }

    @Override
    public synchronized void deposito(double valor) {
        saldo = saldo + valor;
        System.out.println("O valor depositado foi de: " + valor);
    }

    @Override
    public synchronized void saque(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("O valor do saque foi de: " + valor);
        } else {
            System.out.println("Saldo insuficiante!");
        }

    }

    @Override
    public double simulaEmpretimo(double cf, int n) throws IllegalArgumentException {
        if (cf <= 0 || n <= 0) {
            throw new IllegalArgumentException();
        } else {
            return I / (1 - 1 / Math.pow(1 + I, n)) * cf;
        }

    }
}

class SaqueATM extends Thread{
    
    private Conta conta;
    private double saque;
    
    public SaqueATM(Conta conta, double saque){
        this.conta = conta;
        this.saque = saque;
    }
    
    public void run(){
        conta.saque(saque);
    }
}
