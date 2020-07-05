package Classes;

public class ContaFisica implements Conta {

    private double saldo = 0.0;

    //taxa de juros
    private static final double I = 0.03;

    @Override
    public void extrato() {
        System.out.println("Saldo da conta fisica: " + saldo);
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
            System.out.println("Saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiante!");
        }

    }

    @Override
    public double simulaEmpretimo(double cf, int n) {
        if (cf <= 0 || n <= 0) {
            throw new IllegalArgumentException();
        } else {
            return I / (1 - 1 / Math.pow(1 + I, n)) * cf;
        }

    }
}
