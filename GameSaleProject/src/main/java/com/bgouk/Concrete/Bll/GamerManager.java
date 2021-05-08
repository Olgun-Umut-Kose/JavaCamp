package com.bgouk.Concrete.Bll;

import com.bgouk.Abstract.IGamerDal;
import com.bgouk.Abstract.IGamerService;
import com.bgouk.Abstract.IPersonCheckService;
import com.bgouk.Concrete.Entities.Gamer;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class GamerManager implements IGamerService {
    private final IGamerDal _dal;
    private final IPersonCheckService _personCheckService;

    public GamerManager(IGamerDal dal, IPersonCheckService personCheckService) {
        _dal = dal;
        _personCheckService = personCheckService;
    }

    @Override
    public void Add(Gamer gamer) throws MalformedURLException {
        if (_personCheckService.VerifyPerson(gamer)) {_dal.Add(gamer); System.out.println("kayıt başarılı");}
        else System.out.println("lütfen geçerli bir kullanıcı girin");
    }

    @Override
    public void Update(Gamer gamer) {
        _dal.Update(gamer);
    }

    @Override
    public void Delete(Gamer gamer) {
        _dal.Delete(gamer);
    }

    @Override
    public Gamer Get(Predicate<Gamer> predicate) {
        return _dal.Get(predicate);
    }

    @Override
    public ArrayList<Gamer> GetAll(Predicate<Gamer> predicate) {
        return _dal.GetAll(predicate);
    }

    @Override
    public ArrayList<Gamer> GetAll() {
        return _dal.GetAll();
    }


}
