package com.example.lab1komplexjava.business;

import com.example.lab1komplexjava.data.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.lang.model.element.PackageElement;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GameService {
    @Autowired
    PlayerRepository playRep;
    Player player;
    Results results;
    Random random = new Random();
    private List<String> replies;
    private int secret;
    private boolean gameDone = false;

    private void init() {
        secret = random.nextInt(1,11);
        results = new Results();
    }
    public List<PlayerAverage> getAverageResults(){
        return playRep
                .findAll()
                .stream()
                .map(person->new PlayerAverage(
                        person.getUsername(),
                        person
                                .getResults()
                                .stream()
                                .map(Results::getResult)
                                .reduce(0,Integer::sum)*1.0/person.getResults().size()))
                .sorted(Comparator.naturalOrder())
                .toList();

    }

    public String makeGuess(int guess) {

        if (guess < secret) {
            return "Too Low," + " this is your " +  results.getAndIncrement() + " try!";
        } else if (guess > secret) {
            return "Too high!" + " this is your " +  results.getAndIncrement()+ " try!";
        } else {
            player.addResult(results);
            System.out.println("Passed check 1");
            playRep.save(player);
            System.out.println("Passed check 2");
            gameDone = true;
            return  "Just Right," + " it took " + results.getResult() + " tries!";
        }
    }
    public GameService(){
        init();
    }

    public Player getPlayer() {
        return player;
    }

    public Player login(String user){
        List<Player> playerList = playRep.findByName(user);
       if (playerList.size()>0){
           player = playerList.get(0);
       }
       else {
           player = new Player(user);
       }
       init();
       return player;
    }
    public List<Player> getAll(){
       return playRep.findAll();
    }

    public boolean isGameDone() {
        init();
        return gameDone;
    }
}
