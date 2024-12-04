import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    // Adicionar país ao continente
    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    // Calcular a dimensão total do continente
    public double calcularDimensaoTotal() {
        double total = 0;
        for (Pais pais : paises) {
            total += pais.getDimensao();
        }
        return total;
    }

    // Calcular a população total do continente
    public long calcularPopulacaoTotal() {
        long total = 0;
        for (Pais pais : paises) {
            total += pais.getPopulacao();
        }
        return total;
    }

    // Calcular a densidade populacional do continente
    public double calcularDensidadePopulacional() {
        double dimensaoTotal = calcularDimensaoTotal();
        return dimensaoTotal > 0 ? calcularPopulacaoTotal() / dimensaoTotal : 0;
    }

    // País com maior população
    public Pais paisComMaiorPopulacao() {
        Pais maior = null;
        for (Pais pais : paises) {
            if (maior == null || pais.getPopulacao() > maior.getPopulacao()) {
                maior = pais;
            }
        }
        return maior;
    }

    // País com menor população
    public Pais paisComMenorPopulacao() {
        Pais menor = null;
        for (Pais pais : paises) {
            if (menor == null || pais.getPopulacao() < menor.getPopulacao()) {
                menor = pais;
            }
        }
        return menor;
    }

    // País de maior dimensão territorial
    public Pais paisDeMaiorDimensao() {
        Pais maior = null;
        for (Pais pais : paises) {
            if (maior == null || pais.getDimensao() > maior.getDimensao()) {
                maior = pais;
            }
        }
        return maior;
    }

    // País de menor dimensão territorial
    public Pais paisDeMenorDimensao() {
        Pais menor = null;
        for (Pais pais : paises) {
            if (menor == null || pais.getDimensao() < menor.getDimensao()) {
                menor = pais;
            }
        }
        return menor;
    }

    // Razão territorial do maior país em relação ao menor
    public double calcularRazaoTerritorial() {
        Pais maior = paisDeMaiorDimensao();
        Pais menor = paisDeMenorDimensao();
        return menor != null && menor.getDimensao() > 0 ? maior.getDimensao() / menor.getDimensao() : 0;
    }
}
