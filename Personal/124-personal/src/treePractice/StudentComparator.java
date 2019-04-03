package treePractice;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int priority1, priority2;
        priority1 = o1.getStudentYear();
        priority2 = o2.getStudentYear();
        if(o1.getStudentMajor().equals("CS"))
            priority1+=4;
        if(o2.getStudentMajor().equals("CS"))
            priority2+=4;
        if(priority1 > priority2)
            return -1;
        else if (priority2 > priority1)
            return 1;
        else
            return 0;
    }
}
