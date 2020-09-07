/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conrado.luiseduardo_teste.model;

import java.util.Date;


/**
 *
 * @author Conrado
 */
public class Motorista {
    
    private Integer idMotorista;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String modeloCarro;
    private Boolean status;
    private String sexo;
    
    public Motorista(){
        
    }

    public Motorista(Integer idMotorista, String nome, Date dataNascimento, String cpf, String modeloCarro, Boolean status, String sexo) {
        this.idMotorista = idMotorista;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.modeloCarro = modeloCarro;
        this.status = status;
        this.sexo = sexo;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

  
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    //metodo para atualizar o status do motorista
    public void editarStatusMotorista(boolean status){
        this.status=status;
    }

   
    

    
    
    
}
