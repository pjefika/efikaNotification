/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.socket;

import com.telefonica.efikanotification.model.ClienteSocket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *  WebSocker EfikaMobile
 * @author A0077749
 * 
 */
@Component
public class SocketHandler extends TextWebSocketHandler {

    private static List<ClienteSocket> sessions = new ArrayList<ClienteSocket>();

    /**
     * Enviar uma mensagem para todos os clientes
     * @param mensagem
     * @throws IOException 
     */
    public static void sendToClient(String mensagem) throws IOException {
        for (ClienteSocket webSocketSession : sessions) {
            webSocketSession.getSession().sendMessage(new TextMessage(mensagem));
        }
    }
    
    /**
     * Buscar todos os clientes conectados
     * @return 
     */
    public static List<ClienteSocket> getClient(){
        return sessions;
    }
    
    /**
     * Envia uma mensagem para um usuário específico conectado
     * @param matricula
     * @param mensagem
     * @throws IOException 
     */
    public static void sendToUser(String matricula, String mensagem) throws IOException{
        for (ClienteSocket webSocketSession : sessions) {
            if(webSocketSession.getMatricula().equalsIgnoreCase(matricula)){
                webSocketSession.getSession().sendMessage(new TextMessage(mensagem));
            }            
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.stream().filter((webSocketSession) -> (webSocketSession.getSession().equals(session))).forEachOrdered((webSocketSession) -> {
            sessions.remove(webSocketSession);
        }); 
        
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(new ClienteSocket(session));
        session.sendMessage(new TextMessage("Conectado"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        System.out.println("Message received: " + textMessage.getPayload());
        for (ClienteSocket webSocketSession : sessions) {
            if (webSocketSession.getSession().equals(session)) {
                if (textMessage.getPayload().contains("matricula")) {
                    String payload = textMessage.getPayload();
                    String matricula = payload.split(":")[1];
                    webSocketSession.setMatricula(matricula);
                } else {
                    String payload = textMessage.getPayload();
                    webSocketSession.setId(payload);
                }
                webSocketSession.setDataUltimaAcao(new Date());
                webSocketSession.getSession().sendMessage(new TextMessage("Recebido"));
            }
        }
    }

}
