package com.bgouk.Concrete.Bll;

import com.bgouk.Abstract.IGameDal;
import com.bgouk.Abstract.IGameService;
import com.bgouk.Concrete.Entities.Game;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameManager implements IGameService {
    private final IGameDal _dal;

    public GameManager(IGameDal dal) {
        _dal = dal;
    }


    @Override
    public void Add(Game game) {
        _dal.Add(game);
    }

    @Override
    public void Update(Game game) {
        _dal.Update(game);
    }

    @Override
    public void Delete(Game game) {
        _dal.Delete(game);
    }

    @Override
    public Game Get(Predicate<Game> predicate) {
        return _dal.Get(predicate);
    }

    @Override
    public ArrayList<Game> GetAll(Predicate<Game> predicate) {
        return _dal.GetAll(predicate);
    }

    @Override
    public ArrayList<Game> GetAll() {
        return _dal.GetAll();
    }
}
