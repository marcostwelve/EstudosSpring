package br.com.mmjm.libraryAPI.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampoInvalidoException extends RuntimeException {

    public String campo;

    public CampoInvalidoException(String campo, String message) {
        super(message);
        this.campo = campo;
    }
}
