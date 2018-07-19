/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.controller;

import com.telefonica.efikanotification.model.ClienteSocket;
import com.telefonica.efikanotification.socket.SocketHandler;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A0077749
 */
@RequestMapping("/gerenciamento")
@RestController
@Service
public class GerenciamentoController {
    
    @RequestMapping(value = "/ativos", method = RequestMethod.GET)
    public List<ClienteSocket> usuariosConectados(){
        return SocketHandler.getClient();
    }
}
