package com.example.arquiteturaspring.montadora.api;

import com.example.arquiteturaspring.montadora.Carro;
import com.example.arquiteturaspring.montadora.Chave;
import com.example.arquiteturaspring.montadora.HondaHRV;
import com.example.arquiteturaspring.montadora.Motor;
import com.example.arquiteturaspring.montadora.api.Annotation.Aspirado;
import com.example.arquiteturaspring.montadora.api.Annotation.Turbo;
import com.example.arquiteturaspring.montadora.montadora.CarroStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Turbo
    //@Qualifier("Turbo")
    private Motor motor;

    @PostMapping("/ligar-carro")
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);

        return carro.darIgnicao(chave);
    }
}
