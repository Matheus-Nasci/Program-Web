package school.sptech.login01221035MatheusNasci.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        var usuariosListaDto = listaUsuarios.stream().map(Usuario -> new UsuarioDto(Usuario)).collect(Collectors.toList());
        return usuariosListaDto;
    }

    @PostMapping
    public void cadastrar(Usuario novoUsuario) {
        listaUsuarios.add(novoUsuario);
    }


}
