package com.ada.dynamo.exception;

public class ItemNaoEncontradoException extends RuntimeException {
    public ItemNaoEncontradoException(){
        this("Item nao encontrado na base de dados.");
    }
    public ItemNaoEncontradoException(String msg) {
        super(msg);
    }
}
