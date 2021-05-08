package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Game;
import com.bgouk.Concrete.Entities.Gamer;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface IGameService {
    void Add(Game game) ;
    void Update(Game game);
    void Delete(Game game);
    Game Get(Predicate<Game> predicate);
    ArrayList<Game> GetAll(Predicate<Game> predicate);
    ArrayList<Game> GetAll();
}
