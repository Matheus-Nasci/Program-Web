package school.sptech.exercicionota1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    @GetMapping
    public List listar(){
        return herois;
    }

    @GetMapping("/{indice}")
    public String buscarPorIndice(@PathVariable Integer indice){
        if (indice >= 0 && indice < herois.size()){
            return "Herói: " + herois.get(indice).toString();
        }
        return "Nenhum herói encontrado com o indice indicado./";
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public String cadastrar(@PathVariable String nome, @PathVariable String habilidade,
                            @PathVariable Integer idade, @PathVariable Double forca, @PathVariable Boolean vivo){
        if (nome != null && habilidade != null && idade != null && forca != null && vivo != null){

            Heroi heroi = new Heroi(nome, idade, habilidade, forca, vivo);
            herois.add(heroi);

            return "Herói Cadastrado com Sucesso";
        }
        return "Informações incorretas ou incompletas";
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public String atualizar(@PathVariable Integer indice, @PathVariable String nome, @PathVariable String habilidade,
                            @PathVariable Integer idade, @PathVariable Double forca, @PathVariable Boolean vivo){
        if (nome != null && habilidade != null && idade != null && forca != null && vivo != null){

            Heroi heroi = new Heroi(nome, idade, habilidade, forca, vivo);

            herois.set(indice, heroi);

            return "Herói Cadastrado com Sucesso";
        }
        return "Informações incorretas ou incompletas";
    }

    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable Integer indice){
        if (indice >= 0 && indice < herois.size()){

            for (int i = 0; i < herois.size(); i++){
                if (i == indice){
                    herois.remove(i);
                }
            }

            return "Herói removido.";
        }
        return "Nenhum herói encontrado com o indice indicado.";
    }
}
