package frames;

import java.util.Comparator;
import models.Score;

public class SortScoreByStudentId implements Comparator<Score>{

    @Override
    public int compare(Score ds1, Score ds2) {
        return ds1.getStudentId().compareTo(ds2.getStudentId());
    }
}
