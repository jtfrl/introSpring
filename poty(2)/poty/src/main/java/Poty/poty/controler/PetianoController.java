package Poty.poty.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// necessário para que o retorno da lista seja 
// interpretado propriamente (criado em model)
import Poty.poty.model.Petiano;

import Poty.poty.repository.PetianoRepository;

@RestController 
@RequestMapping("/petianos") // controla uma subseção
public class PetianoController {

    @Autowired
    public PetianoRepository repository; // construtor não necessário: annotation acima

    @GetMapping("/get") // permite obter acesso a base; pode ser sem parâmetro
    public List<Petiano> getPetianos(){
        return repository.findAll(); // em SQL: SELECT * FROM petianos
    }

    @PostMapping()
    public Petiano createPetiano(@RequestBody Petiano pet){
        return this.repository.save(pet);
    }
   
}
