/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import org.springframework.web.socket.WebSocketSession;

/**
 *
 * @author A0077749
 */
public class ClienteSocket {
    
    @JsonIgnore
    private WebSocketSession session;
    private String id;
    private Date dataInicio;
    private Date dataUltimaAcao;
    private String matricula;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataUltimaAcao() {
        return dataUltimaAcao;
    }

    public void setDataUltimaAcao(Date dataUltimaAcao) {
        this.dataUltimaAcao = dataUltimaAcao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    public ClienteSocket(WebSocketSession sessao){
        setSession(sessao);
        setDataInicio(new Date());
    }
    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
