package school.sptech.login01221035MatheusNasci.Model;

public class UsuarioDto {
    private String nome;
    private String email;
    private boolean autenticado;

    public UsuarioDto(Usuario usuario) {
        this.nome = nome;
        this.email = email;
        this.autenticado = autenticado;
    }
}
