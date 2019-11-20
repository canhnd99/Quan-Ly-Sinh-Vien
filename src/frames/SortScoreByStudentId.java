package frames;

import java.util.Comparator;
import models.DiemSo;

public class SortScoreByStudentId implements Comparator<DiemSo>{

    @Override
    public int compare(DiemSo ds1, DiemSo ds2) {
        return ds1.getStudentId().compareTo(ds2.getStudentId());
    }
}
