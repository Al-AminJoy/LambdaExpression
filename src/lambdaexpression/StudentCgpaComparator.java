package lambdaexpression;

import java.util.Comparator;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class StudentCgpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        if (a.getGpa() > b.getGpa())
            return -1;
        else if (a.getGpa() < b.getGpa())
            return +1;
        else return 0;
    }
}
