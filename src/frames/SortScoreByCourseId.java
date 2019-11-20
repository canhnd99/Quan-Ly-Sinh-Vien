package frames;

import java.util.Comparator;
import models.DiemSo;

public class SortScoreByCourseId implements Comparator<DiemSo> {

    @Override
    public int compare(DiemSo ds1, DiemSo ds2) {
        return ds1.getCourseId().compareTo(ds2.getCourseId());
    }
}
