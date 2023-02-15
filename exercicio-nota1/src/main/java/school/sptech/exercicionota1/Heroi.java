package school.sptech.exercicionota1;

public class Heroi {

    private String nome;
    private int idade;
    private String habilidade;
    private double forca;
    private boolean vivo;

    public Heroi() {
    }

    public Heroi(String nome, int idade, String habilidade, double forca, boolean vivo) {
        this.nome = nome;
        this.idade = idade;
        this.habilidade = habilidade;
        this.forca = forca;
        this.vivo = vivo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public double getForca() {
        return forca;
    }

    public boolean isVivo() {
        return vivo;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", habilidade='" + habilidade + '\'' +
                ", forca=" + forca +
                ", vivo=" + vivo +
                '}';
    }
}
