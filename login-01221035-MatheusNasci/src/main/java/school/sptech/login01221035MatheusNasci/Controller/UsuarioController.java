package school.sptech.login01221035MatheusNasci.Controller;

import org.springframework.web.bind.annotation.*;
import school.sptech.login01221035MatheusNasci.Model.Usuario;
import school.sptech.login01221035MatheusNasci.Model.UsuarioDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> listaUsuarios;

    public UsuarioController() {
        listaUsuarios = new ArrayList<>();
    }

    @GetMapping
    public List<UsuarioDto> listar() {
        List<UsuarioDto> usuariosListaDto = listaUsuarios
                .stream()
                .map(u -> new UsuarioDto(u))
                .collect(Collectors.toList());
        return usuariosListaDto;
    }

    @PostMapping
    public void cadastrar(@RequestBody Usuario novoUsuario) {
        if(novoUsuario != null){
            listaUsuarios.add(novoUsuario);
        }
    }

    @PostMapping("autenticacao/{email}/{senha}")
    public UsuarioDto autenticar(@PathVariable String email, @PathVariable String senha) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                u.setAutenticado(true);
                var usuarioDto = new UsuarioDto(u);
                return usuarioDto;
            }
        }
        return null;
    }

    @DeleteMapping("autenticacao/{email}")
    public String logoff(@PathVariable String email) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equals(email) && u.getAutenticado() == true) {
                u.setAutenticado(false);
                return String.format("Logoff do usuário %s concluído", u.getNome());
            } else if(u.getEmail().equals(email) && u.getAutenticado() == false){
                return String.format("Usuário NÃO %s está autenticado", email);
            }
        }
        return String.format("Usuário %s não encontrado", email);
    }

    //Remover um usuário passando email como parâmetro.
    @DeleteMapping("/{email}")
    public String remover(@PathVariable String email){
        for (Usuario u : listaUsuarios){
            if (u.getEmail().equals(email)) {
                listaUsuarios.remove(u);
                return (String.format("Usuário %s foi removido.", email));
            }
        }
        return (String.format("Usuário %s .", email));
    }

    //Só consegue atualizar depois de autenticar o usuário.
    //Atualizar o usuário tanto senha quanto email.
    @PutMapping("/{email}")
    public String atualizar(@PathVariable String email, @RequestBody Usuario usuario){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            for (Usuario u : listaUsuarios){
                if (u.getEmail().equals(email) && u.getAutenticado() == true) {
                    listaUsuarios.add(i, usuario);
                    return("Usuário atualizado.");
                }
            }
        }
        return("Usuário não encontrado.");
    }

    //Buscar o usuário passando somente o email como parâmetro.
    @GetMapping("/{email}")
    public UsuarioDto buscarPorEmail(@PathVariable String email){
        for (Usuario u : listaUsuarios){
            if(u.getEmail().equals(email)){
                return new UsuarioDto(u);
            }
        }
        return null;
    }

    //Buscar total de usuário autenticados e não autenticados.
    @GetMapping("/autenticados")
    public String buscarTotalAutenticado(){
        Integer contadorAutenticado = 0;
        Integer contadorNotAutenticado = 0;
        for (Usuario u : listaUsuarios){
            if (u.getAutenticado() == true){
                contadorAutenticado++;
            } else {
                contadorNotAutenticado++;
            }
        }
        return String.format("Usuários autenticados: %d \nUsuários não autenticados: %d", contadorAutenticado, contadorNotAutenticado);
    }
}
