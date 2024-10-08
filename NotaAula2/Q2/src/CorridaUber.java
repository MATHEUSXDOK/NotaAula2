public class CorridaUber {
    private double distancia;
    private int tempoEspera;
    private double tarifaBase;
    private double fatorDemanda;


    public CorridaUber(double distancia, int tempoEspera, double tarifaBase, double fatorDemanda) {
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.tarifaBase = tarifaBase;
        this.fatorDemanda = fatorDemanda;
    }


    public double calcularValorCorrida() {
        double valorFinal = (distancia * 2) + (tempoEspera * 0.5) + (tarifaBase * fatorDemanda);
        return valorFinal;
    }


    public void exibirDetalhesCorrida() {
        System.out.printf("Detalhes da Corrida:\n");
        System.out.printf("Distância percorrida: %.2f km\n", distancia);
        System.out.printf("Tempo de espera: %d minutos\n", tempoEspera);
        System.out.printf("Tarifa base: R$ %.2f\n", tarifaBase);
        System.out.printf("Fator de demanda: %.2f\n", fatorDemanda);
        System.out.printf("Valor final da corrida: R$ %.2f\n", calcularValorCorrida());
    }
}
