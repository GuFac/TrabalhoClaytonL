import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> paisesLimitrofes;

    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.paisesLimitrofes = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getPaisesLimitrofes() {
        return paisesLimitrofes;
    }

    // Adicionar um país limítrofe
    public void adicionarPaisLimitrofe(Pais pais) {
        if (paisesLimitrofes.size() < 40 && !paisesLimitrofes.contains(pais) && !pais.equals(this)) {
            paisesLimitrofes.add(pais);
        }
    }

    // Verificar igualdade semântica
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pais outro = (Pais) obj;
        return this.codigoISO.equals(outro.codigoISO);
    }

    // Verificar se outro país é limítrofe
    public boolean isLimitrofe(Pais outro) {
        return paisesLimitrofes.contains(outro);
    }

    // Calcular a densidade populacional
    public double calcularDensidadePopulacional() {
        return dimensao > 0 ? populacao / dimensao : 0;
    }

    // Encontrar vizinhos comuns entre dois países
    public List<Pais> vizinhosComuns(Pais outro) {
        List<Pais> comuns = new ArrayList<>();
        for (Pais p : this.paisesLimitrofes) {
            if (outro.getPaisesLimitrofes().contains(p)) {
                comuns.add(p);
            }
        }
        return comuns;
    }
}
