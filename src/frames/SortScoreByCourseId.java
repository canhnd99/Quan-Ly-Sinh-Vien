package frames;

import java.util.Comparator;
import models.Score;

public class SortScoreByCourseId implements Comparator<Score> {

    @Override
    public int compare(Score ds1, Score ds2) {
        return ds1.getCourseId().compareTo(ds2.getCourseId());
    }
}
