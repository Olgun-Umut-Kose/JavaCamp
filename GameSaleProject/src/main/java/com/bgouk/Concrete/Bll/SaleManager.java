package com.bgouk.Concrete.Bll;

import com.bgouk.Abstract.ICampaignService;
import com.bgouk.Abstract.ISaleService;
import com.bgouk.Concrete.Entities.Campaign;
import com.bgouk.Concrete.Entities.Game;
import com.bgouk.Concrete.Entities.Gamer;

import java.util.ArrayList;
import java.util.List;

public class SaleManager implements ISaleService {
    private final ICampaignService campaignService;


    public SaleManager(ICampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @Override
    public void GameSale(Gamer gamer, Game game) {
        List<Campaign> tempCampaigns = new ArrayList<Campaign>();
        List<Campaign> campaigns = campaignService.GetAll();
        campaigns.stream().forEach(c -> {

            if(game.getCampaigns().stream().anyMatch(gc -> gc.getId() == c.getId()) && gamer.getCampaigns().stream().anyMatch(gamerc -> gamerc.getId() == c.getId())){
                tempCampaigns.add(c);
            }
        });

        tempCampaigns.forEach(tc -> game.setPrice(game.getPrice() - (game.getPrice() * tc.getDiscount()/100)));
        if ((gamer.getWallet()-game.getPrice())>0){
            gamer.setWallet(gamer.getWallet()-game.getPrice());
            System.out.println(gamer.getFirstName() + " isimli oyuncu " + game.getName() + " isimli oyunu " + game.getPrice() + "TL fiyatına satın almıştır kalan cüzdan bakiyesi: " +gamer.getWallet());
            return;
        }
        System.out.println("Paran yetmiyor faqir");



    }
}
