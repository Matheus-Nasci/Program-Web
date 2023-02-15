package school.sptech.primeiraapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    @GetMapping("/favorito")
    public Heroi favorito(){
        Heroi heroi = new Heroi("Batman", 17, "Rico", 8235.1, true);
        return heroi;
    }

    @GetMapping
    public List<Heroi> listar(){
        return herois;
    }
}
