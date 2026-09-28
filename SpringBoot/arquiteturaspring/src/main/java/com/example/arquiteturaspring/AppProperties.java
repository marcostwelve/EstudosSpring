package com.example.arquiteturaspring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppProperties {

    private String variavel;
    private Integer valor;

    public String getVariavel() {
        return this.variavel;
    }

    public Integer getValor() {
        return this.valor;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
