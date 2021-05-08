package com.bgouk;

import com.bgouk.Concrete.Adapters.MernisAdapter;
import com.bgouk.Concrete.Bll.CampaignManager;
import com.bgouk.Concrete.Bll.GameManager;
import com.bgouk.Concrete.Bll.GamerManager;
import com.bgouk.Concrete.Bll.SaleManager;
import com.bgouk.Concrete.Dal.InMemoryCampaignDal;
import com.bgouk.Concrete.Dal.InMemoryGameDal;
import com.bgouk.Concrete.Dal.InMemoryGamerDal;
import com.bgouk.Concrete.Entities.Campaign;
import com.bgouk.Concrete.Entities.Game;
import com.bgouk.Concrete.Entities.Gamer;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        GameManager gameManager = new GameManager(new InMemoryGameDal());
        CampaignManager campaignManager = new CampaignManager(new InMemoryCampaignDal());
        Gamer gamer = new Gamer(1,"tc","Olgun umut","Köse", LocalDate.of(2005,12,12),999999, campaignManager.GetAll());
        GamerManager gamerManager = new GamerManager(new InMemoryGamerDal(),new MernisAdapter());
        gamerManager.Add(gamer);
        campaignManager.Add(new Campaign(1,"kampanya1",12));
        campaignManager.Add(new Campaign(2,"kampanya2",15));
        SaleManager saleManager = new SaleManager(campaignManager);
        System.out.println(campaignManager.Get(c-> c.getId() ==1).getName());
        saleManager.GameSale(new Gamer(1,"123242342","ad","soyad", LocalDate.of(2005,12,12),999999, campaignManager.GetAll()),new Game(1,"oyyyyuuuun",999, campaignManager.GetAll()));


    }
}
