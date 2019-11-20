package frames;

import java.util.Comparator;
import models.DiemSo;

public class SortByScore implements Comparator<DiemSo>{

    @Override
    public int compare(DiemSo ds1, DiemSo ds2) {
        int s1 = (int) ds1.getScore() * 10;
        int s2 = (int) ds2.getScore() * 10;
        return s1 - s2;
    }
}
