package com.bgouk.Concrete.Dal;

import com.bgouk.Abstract.IEntityDal;
import com.bgouk.Abstract.IGamerDal;
import com.bgouk.Concrete.Entities.Gamer;

public class InMemoryGamerDal extends InMemoryBaseRepo<Gamer> implements IGamerDal {
    @Override
    public void Update(Gamer entity) {
        Gamer gamer = Get(e -> e.getId() == entity.getId());
        gamer.setWallet(entity.getWallet());
        gamer.setDateOfBirth(entity.getDateOfBirth());
        gamer.setLastName(entity.getLastName());
        gamer.setNationalityId(entity.getNationalityId());
        gamer.setFirstName(entity.getFirstName());
        gamer.setCampaigns(entity.getCampaigns());

    }
}
