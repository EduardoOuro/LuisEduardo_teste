/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.model;


import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Conrado
 */
public class Passageiro {
    
    private Integer idPassageiro;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String sexo;
    
    public Passageiro(){
        
    }

    public Passageiro(Integer idPassageiro, String nome, LocalDate dataNascimento, String cpf, String sexo) {
        this.idPassageiro = idPassageiro;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Integer getIdPassageiro() {
        return idPassageiro;
    }

    public void setIdPassageiro(Integer idPassageiro) {
        this.idPassageiro = idPassageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
