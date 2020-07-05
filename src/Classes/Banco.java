package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco {

    private ArrayList<Correntista> listaDeCorentista;

    public Banco() {
        listaDeCorentista = new ArrayList<Correntista>();
    }

    public ArrayList<Correntista> getListaDeCorentista() {
        return listaDeCorentista;
    }

    public void setListaDeCorentista(ArrayList<Correntista> listaDeCorentista) {
        this.listaDeCorentista = listaDeCorentista;
    }

    public void salvarCorrentista() throws IOException {
        File arq = new File("Correntistas.dat");

        FileOutputStream fos = new FileOutputStream(arq);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Correntista c : listaDeCorentista) {
            oos.writeObject(c);
        }

        oos.close();
    }

    public void lerCorrentista() throws IOException, ClassNotFoundException {
        File arq = new File("Correntistas.dat");

        FileInputStream fis = new FileInputStream(arq);

        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = null;
        try {
            while ((obj = ois.readObject()) != null) {
                this.listaDeCorentista.add((Correntista) obj);
            }
        } catch (EOFException e) {

        } finally {
            ois.close();
        }

    }

    public static void main(String[] args) {

        Banco banco = new Banco();
        
        
        ContaFisica conta = new ContaFisica();
        conta.deposito(1000);
        
        CorrentistaFisico igor = new CorrentistaFisico("igor", conta);
        CorrentistaFisico dara = new CorrentistaFisico("dara", conta);
        
        SaqueATM saqueIgor = new SaqueATM(igor.getConta(), 500);
        SaqueATM saqueDara = new SaqueATM(dara.getConta(), 300);
            
        saqueIgor.start();
        saqueDara.start();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        /*CorrentistaFisico cf1 = new CorrentistaFisico("Igor", new ContaFisica());

        CorrentistaFisico cf2 = new CorrentistaFisico("joao", new ContaFisica());

        CorrentistaFisico cf3 = new CorrentistaFisico("marcos", new ContaFisica());

        banco.getListaDeCorentista().add(cf1);
        banco.getListaDeCorentista().add(cf2);
        banco.getListaDeCorentista().add(cf3);

        CorrentistaJuritico cj1 = new CorrentistaJuritico("newgen", "William", new ContaJuridica());

        CorrentistaJuritico cj2 = new CorrentistaJuritico("algar", "fulano", new ContaJuridica());

        banco.getListaDeCorentista().add(cj1);
        banco.getListaDeCorentista().add(cj2);

        try {
            banco.salvarCorrentista();
        } catch (IOException ex) {

        }
        try {
            banco.lerCorrentista();
            
            for(Correntista c : banco.getListaDeCorentista()){
                System.out.println(c.getCodigo() +" - "+ c.getNome());
            }
        } catch (Exception e) {

        }

        
        
        
        
        
        
         double parcelas = cf1.getConta().simulaEmpretimo(1000, 18);
            System.out.println(parcelas);
            
            Iterator<Correntista> it = listaDeCorentista.iterator();
            
            while(it.hasNext()){
            System.out.println(it.next().getNome());
            }
            File arqBanco = new File("D:\\NetBeansProjects\\SistemaBancario\\src\\Classes\\banco.txt");
            
            try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arqBanco, true));//o true = não sobrescrever o arquivo
            
            writer.write("\naté logo");
            writer.close();
            
            } catch (Exception e) {
            
            }
            
            try {
            BufferedReader reader = new BufferedReader(new FileReader(arqBanco));

            String linha = "";
            while ((linha = reader.readLine()) != null) {
            System.out.println(linha);
            
            }
            reader.close();
            
            } catch (Exception e) {
            
            }*/
    }
}
