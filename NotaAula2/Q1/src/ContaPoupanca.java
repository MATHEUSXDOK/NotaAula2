public class ContaPoupanca extends Conta {
    private double taxaSelic;

    public ContaPoupanca(String titular, double taxaSelic) {
        super(titular);
        this.taxaSelic = taxaSelic;
    }

    public void calcularRendimento() {
        double rendimento;
        if (taxaSelic > 8.5) {
            rendimento = saldo * 0.005;
        } else {
            rendimento = saldo * (taxaSelic / 100) * 0.7;
        }
        saldo += rendimento;
        System.out.printf("Rendimento calculado: R$ %.2f\n", rendimento);
    }

    @Override
    public void exibirDados() {
        System.out.printf("Titular: %s\n", titular);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
        System.out.printf("Taxa Selic: %.2f%%\n", taxaSelic);
    }
}
