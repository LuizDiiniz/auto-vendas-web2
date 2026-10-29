package br.edu.vendas.model;

public enum Cambio {
    MANUAL("Manual"),
    AUTOMATICO("Automático"),
    CVT("CVT");

    private final String rotulo;
    Cambio(String rotulo) { this.rotulo = rotulo; }
    public String getRotulo() { return rotulo; }
}
