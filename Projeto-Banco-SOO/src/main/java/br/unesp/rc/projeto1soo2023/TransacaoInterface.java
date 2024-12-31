package br.unesp.rc.projeto1soo2023;

import java.util.Date;

public class TransacaoInterface extends Projeto1SOO2023{
    private Date data;
    private String descricao;
    private double valor;

    public TransacaoInterface(Date data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}