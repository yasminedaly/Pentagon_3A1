/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagon3a1.controller;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

/**
 *
 * @author Moudhaffer
 */
public class ovelayTool {
    public static void test(){
        Orianna.setRiotAPIKey("YOUR-API-KEY");
        Orianna.setDefaultRegion(Region.EUROPE_WEST);

        Summoner summoner = Orianna.summonerNamed("FatalElement").get();
        System.out.println(summoner.getName() + " is level " + summoner.getLevel() + " on the " + summoner.getRegion() + " server.");

        Champions champions = Orianna.getChampions();
        Champion randomChampion = champions.get((int)(Math.random() * champions.size()));
        System.out.println("He enjoys playing champions such as " + randomChampion.getName());

        League challengerLeague = Orianna.challengerLeagueInQueue(Queue.RANKED_SOLO).get();
        Summoner bestNA = challengerLeague.get(0).getSummoner();
        System.out.println("He's not as good as " + bestNA.getName() + " at League, but probably a better Java programmer!");
    }
    
}
