package com.gamesapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gamesapp.web.model.GameModel;
import com.gamesapp.web.repository.GameRepository;

@Controller
public class GameController {

    @Autowired // -> é uma injeção de dependencias. Uma instancia
    private GameRepository gameRepository;

    @RequestMapping(value = "/cadastrarGame", method = RequestMethod.GET) // -> GET porque ele retorna um formulario
    public String form() {

        return "formCadastrarGame";
    }

    @RequestMapping(value = "/cadastrarGame", method = RequestMethod.POST) // -> GET porque ele retorna um formulario
    public String form(final GameModel gameModel) {

        //salva o gameModel(registro) no banco de dados
        gameRepository.save(gameModel);

        return "redirect:/cadastrarGame";
    }

    @RequestMapping("/listaGames")
    public ModelAndView listaDeGames() {

        final ModelAndView modelAndView = new ModelAndView("index");

        final Iterable<GameModel> gameList = gameRepository.findAll();

        modelAndView.addObject("gameList", gameList);

        return modelAndView;

    }

    @RequestMapping("/deletaGame")
    public String deletaGame(final long id) {

        final GameModel game = gameRepository.findById(id);

        gameRepository.delete(game);

        return "redirect:/listaGames";
    }

    @RequestMapping("/{idDetalheGame}/detalhe")
    public ModelAndView detalheGame(@PathVariable("idDetalheGame") final long id) {

        final ModelAndView modelAndView = new ModelAndView("detalheGame");

        final GameModel game = gameRepository.findById(id);

        modelAndView.addObject("gameSelecionado", game);

        return modelAndView;
    }

}
