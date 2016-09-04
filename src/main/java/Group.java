import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomko_2 on 2016-08-25.
 */
public class Group {

    private int numOfTeams;
    private FixedSizeList<FootballClub> teams;

    public Group(List<FootballClub> teams) {
        this.teams=new FixedSizeList<FootballClub>(teams);
    }

    public Group(int numOfTeams) {
        this.teams=new FixedSizeList<FootballClub>(numOfTeams);
        this.numOfTeams=numOfTeams;
    }

    public void addTeam(FootballClub cl) {
        teams.add(cl);
    }

    public ArrayList<FootballClub> getTeams() {
        return new ArrayList<FootballClub>(teams);
    }
}
