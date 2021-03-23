package br.com.jpa.model;

public class MediaComData {

    private Double valor;
    private Integer dias;
    private Integer mes;

    public Double getValor() {
        return valor;
    }

    public Integer getDias() {
        return dias;
    }

    public Integer getMes() {
        return mes;
    }


    public MediaComData(Double valor, Integer dias, Integer mes) {
        this.valor = valor;
        this.dias = dias;
        this.mes = mes;
    }
}
