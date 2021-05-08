package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Game;
import com.bgouk.Concrete.Entities.Gamer;

public interface ISaleService {
    void GameSale(Gamer gamer, Game game);

}
