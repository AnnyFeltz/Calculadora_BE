import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        CalculadoraInterface calc = null;

        try {
            calc = (CalculadoraInterface) Naming.lookup("rmi://servidor:1099/Calculadora");
            System.out.println("Conectado ao servidor RMI!");
        } catch (RemoteException e) {
            System.err.println("Erro de comunicação RMI: " + e.getMessage());
            return;
        } catch (NotBoundException e) {
            System.err.println("Objeto não encontrado no registry: " + e.getMessage());
            return;
        } catch (MalformedURLException e) {
            System.err.println("URL do servidor inválida: " + e.getMessage());
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== CALCULADORA REMOTA =====");
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Encerrando...");
                break;
            }

            System.out.print("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = scanner.nextDouble();

            try {
                double resultado = switch (opcao) {
                    case 1 -> calc.somar(a, b);
                    case 2 -> calc.subtrair(a, b);
                    case 3 -> calc.multiplicar(a, b);
                    case 4 -> calc.dividir(a, b);
                    default -> {
                        System.out.println("Opção inválida!");
                        yield Double.NaN;
                    }
                };

                if (!Double.isNaN(resultado)) {
                    System.out.println("Resultado: " + resultado);
                }

            } catch (RemoteException e) {
                System.err.println("Erro ao executar operação: " + e.getMessage());
            }
        }

        scanner.close();
    }
}