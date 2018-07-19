/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.model;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author A0077749
 */
@Document(collection = "notificacao")
public class Notificacao {
    @Id
    private String id;
    private String titulo;
    private String mensagem;
    private Date data_inicio;
    private Date data_fim;
    private String responsavel;
    private AcaoNotificacao action;
    private TipoNotificacaoEnum tipo;

    public TipoNotificacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacaoEnum tipo) {
        this.tipo = tipo;
    }
    
    

    public AcaoNotificacao getAction() {
        return action;
    }

    public void setAction(AcaoNotificacao action) {
        this.action = action;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    
}
