public class ContaCorrente extends Conta {
    private final double chequeEspecial = 1000.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    public boolean usarChequeEspecial(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.printf("Uso de cheque especial no valor de R$ %.2f autorizado.\n", valor);
            return true;
        } else {
            System.out.println("Limite de cheque especial excedido.");
            return false;
        }
    }

    @Override
    public void exibirDados() {
        System.out.printf("Titular: %s\n", titular);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
        System.out.printf("Limite de Cheque Especial: R$ %.2f\n", chequeEspecial);
    }
}

