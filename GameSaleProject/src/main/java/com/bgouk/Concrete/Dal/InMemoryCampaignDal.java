package com.bgouk.Concrete.Dal;

import com.bgouk.Abstract.ICampaignDal;
import com.bgouk.Concrete.Entities.Campaign;

public class InMemoryCampaignDal extends InMemoryBaseRepo<Campaign> implements ICampaignDal {
    @Override
    public void Update(Campaign entity) {
        Campaign campaign = Get((e -> e.getId() == entity.getId()));
        campaign.setName(entity.getName());
        campaign.setDiscount(entity.getDiscount());
    }
}
