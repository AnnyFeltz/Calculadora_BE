import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            CalculadoraImpl calc = new CalculadoraImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculadora", calc);
            System.out.println("Servidor pronto na porta 1099.");
        } catch (RemoteException e) {
            System.err.println("Erro ao iniciar o servidor RMI: " + e.getMessage());
        }
    }
}