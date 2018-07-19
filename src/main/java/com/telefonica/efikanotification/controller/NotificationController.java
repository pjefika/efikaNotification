/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.controller;

import com.telefonica.efikanotification.model.Notificacao;
import com.telefonica.efikanotification.repository.NotificacaoRepositorio;
import com.telefonica.efikanotification.socket.SocketHandler;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A0077749
 */
@RequestMapping("/notificacao")
@RestController
@Service
public class NotificationController {

    @Autowired
    private NotificacaoRepositorio repositorio;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Notificacao> get() throws ParseException {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 4);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return repositorio.getListAtivas(new Date(), calendar.getTime());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Notificacao create(@RequestBody Notificacao notificacao) {
        Notificacao nova = repositorio.insert(notificacao);
        return nova;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Notificacao update(@RequestBody Notificacao notificacao) {
        Notificacao nova = repositorio.save(notificacao);
        return nova;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(String id) {
        repositorio.deleteById(id);
        return true;
    }
    
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Notificacao> getAll() throws ParseException {
        return repositorio.findAll();
    }
    
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendToclient(String mensagem) throws IOException{
        SocketHandler.sendToClient(mensagem);
        return "Enviado";
    }
    
    @RequestMapping(value = "/sendToUsuario", method = RequestMethod.GET)
    public String sendToclient(String matricula, String mensagem) throws IOException{
        SocketHandler.sendToUser(matricula, mensagem);
        return "Enviado";
    }
}
