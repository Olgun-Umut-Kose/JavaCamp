package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Campaign;
import com.bgouk.Concrete.Entities.Game;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface ICampaignService {
    void Add(Campaign campaign);
    void Update(Campaign campaign);
    void Delete(Campaign campaign);
    Campaign Get(Predicate<Campaign> predicate);
    ArrayList<Campaign> GetAll(Predicate<Campaign> predicate);
    ArrayList<Campaign> GetAll();
}
