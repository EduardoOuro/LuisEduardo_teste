/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.model;

/**
 *
 * @author Conrado
 */
public class Corrida {
    
    private Integer idCorrida;
    private Double valorCorrida;
    private Motorista motorista;
    private Passageiro passageiro;
    
    public Corrida(){
        
    }

    public Corrida(Integer idCorrida, Double valorCorrida, Motorista motorista, Passageiro passageiro) {
        this.idCorrida = idCorrida;
        this.valorCorrida = valorCorrida;
        this.motorista = motorista;
        this.passageiro = passageiro;
    }

    public Integer getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(Integer idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Double getValorCorrida() {
        return valorCorrida;
    }

    public void setValorCorrida(Double valorCorrida) {
        this.valorCorrida = valorCorrida;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
    
}
