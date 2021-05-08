package com.bgouk.Concrete.Bll;

import com.bgouk.Abstract.ICampaignDal;
import com.bgouk.Abstract.ICampaignService;
import com.bgouk.Concrete.Entities.Campaign;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CampaignManager implements ICampaignService {
    private final ICampaignDal _dal;

    public CampaignManager(ICampaignDal dal) {
        _dal = dal;
    }


    @Override
    public void Add(Campaign campaign) {
        _dal.Add(campaign);
    }

    @Override
    public void Update(Campaign campaign) {
        _dal.Update(campaign);
    }

    @Override
    public void Delete(Campaign campaign) {
        _dal.Delete(campaign);
    }

    @Override
    public Campaign Get(Predicate<Campaign> predicate) {
        return _dal.Get(predicate);
    }

    @Override
    public ArrayList<Campaign> GetAll(Predicate<Campaign> predicate) {
        return _dal.GetAll(predicate);
    }

    @Override
    public ArrayList<Campaign> GetAll() {
        return _dal.GetAll();
    }
}
