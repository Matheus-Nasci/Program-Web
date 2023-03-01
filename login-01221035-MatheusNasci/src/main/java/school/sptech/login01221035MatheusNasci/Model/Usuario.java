package school.sptech.login01221035MatheusNasci.Model;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean autenticado;

    public Usuario(){

    }
    public Usuario(String nome, String email, String senha, boolean autenticado) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.autenticado = autenticado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
