package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Gamer;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public interface IGamerService {
    void Add(Gamer gamer) throws MalformedURLException;
    void Update(Gamer gamer);
    void Delete(Gamer gamer);
    Gamer Get(Predicate<Gamer> predicate);
    ArrayList<Gamer> GetAll(Predicate<Gamer> predicate);
    ArrayList<Gamer> GetAll();
}
