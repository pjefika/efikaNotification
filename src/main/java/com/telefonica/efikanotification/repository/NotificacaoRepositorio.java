/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.repository;

import com.telefonica.efikanotification.model.Notificacao;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author A0077749
 */
public interface NotificacaoRepositorio extends MongoRepository<Notificacao, String> {
    @Query("{ 'data_fim' : { $lt: ?1 } }")
    List<Notificacao> getListAtivas(Date inicio, Date fim);
}
