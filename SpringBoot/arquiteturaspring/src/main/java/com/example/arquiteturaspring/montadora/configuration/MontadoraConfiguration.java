package com.example.arquiteturaspring.montadora.configuration;

import com.example.arquiteturaspring.montadora.Motor;
import com.example.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "Aspirado")
    @Primary
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO - 1.0");
        motor.setLitragem(1.5);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "Eletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(150);
        motor.setCilindros(6);
        motor.setModelo("TH-40");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "Turbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(300);
        motor.setCilindros(8);
        motor.setModelo("Turbo - 2.5");
        motor.setLitragem(3.0);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }
}
