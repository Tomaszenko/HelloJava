import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tomko_2 on 2016-08-25.
 */
public class Pot {
    private int toBeDrawn;
    private List<FootballClub> clubs;

    public Pot(List<FootballClub> clubs) {
        this.toBeDrawn=clubs.size();
        this.clubs=clubs;
    }

    public FootballClub draw() {
        int pos=(int)(Math.random()*toBeDrawn);
        FootballClub result=clubs.get(pos);
        Collections.swap(clubs,pos,--toBeDrawn);
        return result;
    }

    public void reset() {
        this.toBeDrawn=clubs.size();
    }
}
