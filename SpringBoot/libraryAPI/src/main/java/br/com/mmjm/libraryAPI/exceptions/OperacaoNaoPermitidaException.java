package br.com.mmjm.libraryAPI.exceptions;

public class OperacaoNaoPermitidaException extends RuntimeException {
    public OperacaoNaoPermitidaException(String msg) {
        super(msg);
    }
}
