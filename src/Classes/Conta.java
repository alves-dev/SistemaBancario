
package Classes;

import java.io.Serializable;

public interface Conta extends Serializable {
    
    public void extrato();
    
    public void deposito(double valor);
    
    public void saque(double valor);
    
    //cf = capital financiado, n = messesS
    public double simulaEmpretimo(double cf, int n);
    
}
