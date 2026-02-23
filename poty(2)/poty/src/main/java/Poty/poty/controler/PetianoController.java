package Poty.poty.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import Poty.poty.repository.; conferir nos arquivos do drive

import Poty.poty.repository.PetianoRepository;

@RestController
@RequestMapping("/petianos") // controla uma subseção
public class PetianoController {

    @Autowired
    public PetianoRepository repository; // construtor não necessário: annotation acima

    public List<Petiano> getPetianos(){
        return repository.findAll();
    }
}
