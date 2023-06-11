import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class exercicio2 {

    public static void main(String[] args) {
        // Tabela de status dos pagamentos previstos por empresa
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            pagamentos.add(new Pagamento("F", "01/05/2022", 0));
            pagamentos.add(new Pagamento("A", "03/04/2022", 1));
            pagamentos.add(new Pagamento("C", "04/04/2022", 1));
            pagamentos.add(new Pagamento("A", "06/06/2022", 1));
            pagamentos.add(new Pagamento("B", "20/06/2022", 0));
            pagamentos.add(new Pagamento("B", "21/06/2022", 0));
            pagamentos.add(new Pagamento("I", "01/05/2022", 1));
            pagamentos.add(new Pagamento("I", "03/04/2022", 0));
            pagamentos.add(new Pagamento("F", "04/04/2022", 1));
            pagamentos.add(new Pagamento("F", "06/06/2022", 0));
            pagamentos.add(new Pagamento("A", "20/06/2022", 0));
            pagamentos.add(new Pagamento("C", "21/06/2022", 0));
            pagamentos.add(new Pagamento("C", "12/03/2022", 1));
            pagamentos.add(new Pagamento("C", "14/07/2022", 1));
            pagamentos.add(new Pagamento("C", "15/07/2022", 1));
            pagamentos.add(new Pagamento("B", "12/07/2022", 0));
            pagamentos.add(new Pagamento("I", "15/07/2022", 1));
            pagamentos.add(new Pagamento("I", "16/06/2022", 1));
            pagamentos.add(new Pagamento("A", "10/05/2022", 0));
            pagamentos.add(new Pagamento("B", "12/03/2022", 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Calcular média de pagamentos por empresa
        Map<String, Integer> totalPagamentos = new HashMap<>();
        Map<String, Integer> pagamentosRealizados = new HashMap<>();
        for (Pagamento pagamento : pagamentos) {
            String empresa = pagamento.getEmpresa();
            totalPagamentos.put(empresa, totalPagamentos.getOrDefault(empresa, 0) + 1);
            if (pagamento.isPago()) {
                pagamentosRealizados.put(empresa, pagamentosRealizados.getOrDefault(empresa, 0) + 1);
            }
        }

        // Calcular média de pagamentos por empresa
        Map<String, Double> mediaPagamentos = new HashMap<>();
        for (String empresa : totalPagamentos.keySet()) {
            int total = totalPagamentos.get(empresa);
            int realizados = pagamentosRealizados.getOrDefault(empresa, 0);
            double media = (double) realizados / total;
            mediaPagamentos.put(empresa, media);
        }

        // Publicar ranking de empresas
        System.out.println("Ranking de pagadores:");
        List<Map.Entry<String, Double>> sortedRanking = new ArrayList<>(mediaPagamentos.entrySet());
        sortedRanking.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int rank = 1;
        for (Map.Entry<String, Double> entry : sortedRanking) {
            System.out.println(rank + "º lugar: " + entry.getKey() + " - Média de pagamentos: " + entry.getValue());
            rank++;
        }
    }

    static class Pagamento {
        private String empresa;
        private Date data;
        private int pago;

        public Pagamento(String empresa, String dataStr, int pago) throws ParseException {
            this.empresa = empresa;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.data = sdf.parse(dataStr);
            this.pago = pago;
        }

        public String getEmpresa() {
            return empresa;
        }

        public Date getData() {
            return data;
        }

        public boolean isPago() {
            return pago == 1;
        }
    }
}