package com.bgouk.Concrete.Dal;

import com.bgouk.Abstract.IEntityDal;
import com.bgouk.Abstract.IGameDal;
import com.bgouk.Abstract.IGamerDal;
import com.bgouk.Concrete.Entities.Game;

public class InMemoryGameDal extends InMemoryBaseRepo<Game> implements IGameDal {

    @Override
    public void Update(Game entity) {
        Game game = Get(e -> e.getId() == entity.getId());
        game.setName(entity.getName());
        game.setPrice(entity.getPrice());
        game.setCampaigns(entity.getCampaigns());
    }
}
