package br.com.leangua.empresa.models;

public class Empresa {

    private String cnpj;

    private double capital_social;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getCapital_social() {
        return capital_social;
    }

    public void setCapital_social(double capital_social) {
        this.capital_social = capital_social;
    }
}