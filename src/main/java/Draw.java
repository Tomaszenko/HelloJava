import java.util.*;

/**
 * Created by tomko_2 on 2016-08-25.
 */
public class Draw {

    private int totalNumber;
    private FixedSizeList<Pot> pots;

    public Draw(int nrOfPots, List<FootballClub> clubs) {
        this.totalNumber=clubs.size();
        this.pots=new FixedSizeList<Pot>(nrOfPots);

        for(int i=0;i<nrOfPots;++i) {
            int begin=i*totalNumber/nrOfPots;
            int end=(i+1)*totalNumber/nrOfPots;
            Pot p=new Pot(clubs.subList(begin,end));
            pots.add(p);
        }
    }

    public Map<Character,Group> drawGroups() {

        int numOfPots=getNumberOfPots();
        int numOfGroups=getNumberOfGroups();
        Map<Character,Group> results=new TreeMap<Character, Group>();
        for(int i=0;i!=numOfGroups;++i) {
            results.put((char)('A'+i),new Group(numOfPots));
        }

        List<Character> letters=new ArrayList<Character>();

        for(int i=0;i!=numOfGroups;i++) {
            letters.add((char)('A'+i));
        }

        for(int i=pots.size()-1;i>=0;--i) {
            for(int j=numOfGroups-1;j>=0;--j) {
                FootballClub drawnTeam = pots.get(i).draw();
                int drawnGroup=(int)(Math.random()*j);
                Character drGroup=letters.get(drawnGroup);
                Collections.swap(letters,drawnGroup,j);
                results.get(drGroup).addTeam(drawnTeam);
                for(Map.Entry<Character,Group> entry: results.entrySet()) {
                    Group gr=entry.getValue();
                    Character letter=entry.getKey();
                    System.out.println("Grupa "+letter);
                    for(FootballClub cl: gr.getTeams()) {
                        System.out.println(cl.getName());
                    }
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }

        return results;

    }

    public int getNumberOfPots() {
        return pots.size();
    }

    public int getNumberOfGroups() {
        return totalNumber/getNumberOfPots();
    }
}
