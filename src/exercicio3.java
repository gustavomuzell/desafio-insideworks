public class exercicio3 {

    public static void main(String[] args) {
        int[][] consumo = {
                {100, 120, 130, 110, 105, 95, 85, 90, 100, 110, 120, 115},
                {105, 115, 125, 115, 110, 100, 90, 95, 105, 115, 125, 120},
                {110, 130, 135, 125, 120, 110, 100, 105, 110, 130, 135, 130},
                {95, 105, 115, 105, 100, 90, 80, 85, 95, 105, 115, 110},
                {120, 140, 145, 135, 130, 120, 110, 115, 120, 140, 145, 140},
                {100, 110, 120, 110, 105, 95, 85, 90, 100, 110, 120, 115},
                {90, 100, 110, 100, 95, 85, 75, 80, 90, 100, 110, 105},
                {115, 125, 135, 125, 120, 110, 100, 105, 115, 125, 135, 130},
                {130, 150, 155, 145, 140, 130, 120, 125, 130, 150, 155, 150},
                {95, 105, 115, 105, 100, 90, 80, 85, 95, 105, 115, 110}
        };

        // Calcular consumo médio em cada mês
        double[] mediaMensal = new double[12];
        for (int mes = 0; mes < 12; mes++) {
            int soma = 0;
            for (int ano = 0; ano < 10; ano++) {
                soma += consumo[ano][mes];
            }
            mediaMensal[mes] = (double) soma / 10;
            System.out.println("Média do mês " + (mes + 1) + ": " + mediaMensal[mes]);
        }

        // Encontrar o mês/ano com maior consumo
        int maxConsumo = Integer.MIN_VALUE;
        int anoMaxConsumo = -1;
        int mesMaxConsumo = -1;
        for (int ano = 0; ano < 10; ano++) {
            for (int mes = 0; mes < 12; mes++) {
                if (consumo[ano][mes] > maxConsumo) {
                    maxConsumo = consumo[ano][mes];
                    anoMaxConsumo = ano + 2010;
                    mesMaxConsumo = mes + 1;
                }
            }
        }
        System.out.println("Mês/ano com maior consumo: " + mesMaxConsumo + "/" + anoMaxConsumo);
    }
}
