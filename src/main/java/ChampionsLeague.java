import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by tomko_2 on 2016-08-25.
 */
public class ChampionsLeague {
    public static void main(String[] args) {

        Scanner sc=null;
        String relativePath="src/main/resources/teams.txt";
        System.out.println(new File(relativePath).getAbsolutePath());

        int nrOfParticipants=32;
        List<FootballClub> contestors=new FixedSizeList<FootballClub>(nrOfParticipants);

        try {
            //sc = new Scanner(new File(relativePath));
            sc=new Scanner(ChampionsLeague.class.getResourceAsStream("/teams.txt"));
            while(sc.hasNextLine()) {
                System.out.println("kukulele");
                contestors.add(new FootballClub(sc.nextLine()));
            }
        }
        catch(Exception e) {
            System.out.println("Nie można otworzyć pliku");
        }
        finally {
            if(sc!=null) {
                System.out.println("łubudubu");
                sc.close();
            }
        }

        ArrayList<Group> groups=new ArrayList<Group>(8);
        System.out.println(contestors.size());

        Draw champLeague=new Draw(4,contestors);
        showGroups(champLeague.drawGroups());


    }

    public static void showGroups(Map<Character,Group> map) {
        for(Map.Entry<Character,Group> entry: map.entrySet()) {
            System.out.println("Grupa "+entry.getKey()+":");
            for(FootballClub fcl: entry.getValue().getTeams()) {
                System.out.println(fcl.getName());
            }
            System.out.println();
        }
    }
}