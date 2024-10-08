import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int opcaoConta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do titular:");
        String titular = scanner.nextLine();

        Conta conta = null;

        if (opcaoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (opcaoConta == 2) {
            System.out.println("Digite a taxa Selic atual (em %):");
            double taxaSelic = scanner.nextDouble();
            conta = new ContaPoupanca(titular, taxaSelic);
        }

        boolean sair = false;
        while (!sair) {
            System.out.println("\nMenu de opções:");
            if (conta instanceof ContaCorrente) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Usar Cheque Especial");
                System.out.println("4. Exibir dados da conta");
                System.out.println("5. Sair");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Calcular rendimento");
                System.out.println("4. Exibir dados da conta");
                System.out.println("5. Sair");
            }

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor para depósito:");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 2:
                    System.out.println("Digite o valor para saque:");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        System.out.println("Digite o valor para usar do cheque especial:");
                        double valorCheque = scanner.nextDouble();
                        ((ContaCorrente) conta).usarChequeEspecial(valorCheque);
                    } else if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).calcularRendimento();
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
        System.out.println("Obrigado por usar o sistema bancário!");
    }
}
