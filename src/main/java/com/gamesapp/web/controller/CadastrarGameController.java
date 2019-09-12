package com.gamesapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gamesapp.web.model.GameModel;
import com.gamesapp.web.repository.EventoRepository;

@Controller
public class CadastrarGameController {

    @Autowired // -> é uma injeção de dependencias. Uma instancia
    private EventoRepository eventoRepository;

    @RequestMapping(value = "/cadastrarGame", method = RequestMethod.GET) // -> GET porque ele retorna um formuçarop
    public String form() {

        return "formCadastrarGame";
    }

    @RequestMapping(value = "/cadastrarGame", method = RequestMethod.POST) // -> GET porque ele retorna um formuçarop
    public String form(final GameModel gameModel) {

        //salva o gameModel(registro) no banco de dados
        eventoRepository.save(gameModel);

        return "redirect:/cadastrarGame";
    }

}
