package school.sptech.primeiraapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private List<String> pokemon = new ArrayList<>();

    @GetMapping
    public String listar(){
        return "Tamanho lista: " + pokemon.size();
    }

    @GetMapping("/cadastrar/{nome}")
    public String adicionar(@PathVariable String nome){
        pokemon.add(nome);
        return "Pokemon adicionado com sucesso";
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperar(@PathVariable Integer indice){

        if (indice != null || indice >= 0 && indice < pokemon.size()){
            return "Pokemon: " + pokemon.get(indice);
        }
        return "Pokemon não encontrado";
    }

    @GetMapping("/pokemon/excluir/{indice}")
    public String deletar(@PathVariable Integer indice){

        for (int i = 0; i < pokemon.size(); i++){
            if(indice == i){
                pokemon.remove(i);
                return "Pokemon deletado com sucesso";
            }
        }
        return "Pokemon não existe";
    }

    @GetMapping("/atualizar/{indice}/{novoNome}")
    public String atualizar(@PathVariable Integer indice, @PathVariable String novoNome){
        for (int i = 0; i < pokemon.size(); i++){
            if (indice == i){
                pokemon.set(indice, novoNome);
                return "Pokemon Atualizado";
            }
        }
        return "Pokemon não encontrado";
    }
}