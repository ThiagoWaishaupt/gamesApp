package com.gamesapp.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.gamesapp.web.model.GameModel;

public interface EventoRepository extends CrudRepository<GameModel, String> {
    //Interface para utilizar métodos: salvar, deletar, update, etc... no DB

}
