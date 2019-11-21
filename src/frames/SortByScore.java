package frames;

import java.util.Comparator;
import models.Score;

public class SortByScore implements Comparator<Score>{

    @Override
    public int compare(Score ds1, Score ds2) {
        int s1 = (int) ds1.getScore() * 10;
        int s2 = (int) ds2.getScore() * 10;
        return s1 - s2;
    }
}
