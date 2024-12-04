public class Main {
    public static void main(String[] args) {
        // Criando países
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(213993437); // Configurando a população

        Pais argentina = new Pais("ARG", "Argentina", 2780400.0);
        argentina.setPopulacao(45605823);

        Pais uruguai = new Pais("URU", "Uruguai", 176215.0);
        uruguai.setPopulacao(3518552);

        // Configurando países limítrofes
        brasil.adicionarPaisLimitrofe(argentina);
        brasil.adicionarPaisLimitrofe(uruguai);
        argentina.adicionarPaisLimitrofe(uruguai);

        // Exibindo densidade populacional
        System.out.println("Densidade do Brasil: " + brasil.calcularDensidadePopulacional());
        System.out.println("Densidade da Argentina: " + argentina.calcularDensidadePopulacional());

        // Verificando vizinhos comuns
        System.out.println("Vizinhos comuns entre Brasil e Argentina: ");
        for (Pais pais : brasil.vizinhosComuns(argentina)) {
            System.out.println(pais.getNome());
        }

        // Criando continente
        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(uruguai);

        // Exibindo informações do continente
        System.out.println("Dimensão total da América do Sul: " + americaDoSul.calcularDimensaoTotal());
        System.out.println("População total da América do Sul: " + americaDoSul.calcularPopulacaoTotal());
        System.out.println("Densidade populacional da América do Sul: " + americaDoSul.calcularDensidadePopulacional());

        // Países de maior e menor população
        System.out.println("País com maior população: " + americaDoSul.paisComMaiorPopulacao().getNome());
        System.out.println("País com menor população: " + americaDoSul.paisComMenorPopulacao().getNome());
    }
}
