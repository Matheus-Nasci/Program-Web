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
        listaUsuarios.add(novoUsuario);
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

    @DeleteMapping("/{email}")
    public void remover(@PathVariable String email){
        for (Usuario u : listaUsuarios){
            if (u.getEmail().equals(email)) {
                listaUsuarios.remove(u);
            }
        }
    }

    @PutMapping("")
    public void atualizar(@RequestBody Usuario usuarioAtualizado){

    }
}
