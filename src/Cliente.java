import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Cliente {
    public static void main(String[] args) {
        try {
            CalculadoraInterface calc = (CalculadoraInterface) Naming.lookup("rmi://servidor:1099/Calculadora");

            System.out.println("10 + 5 = " + calc.somar(10, 5));
            System.out.println("10 - 5 = " + calc.subtrair(10, 5));
            System.out.println("10 * 5 = " + calc.multiplicar(10, 5));
            System.out.println("10 / 5 = " + calc.dividir(10, 5));

        } catch (RemoteException e) {
            System.err.println("Erro de comunicação RMI: " + e.getMessage());
        } catch (NotBoundException e) {
            System.err.println("Objeto não encontrado no registry: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.err.println("URL do servidor inválida: " + e.getMessage());
        }
    }
}