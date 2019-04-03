package treePractice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WaitList {
    private PriorityQueue<Student> waitlist;

    public WaitList(){
        StudentComparator sc = new StudentComparator();
        waitlist = new PriorityQueue<>(10, sc);
    }

    public boolean joinWaitList(Student s){
        waitlist.offer(s);
        return true;
    }

    public int waitListSize(){
        return waitlist.size();
    }

    public ArrayList<Student> getClassRoster(int n){
        ArrayList<Student> roster = new ArrayList<>();
        Student s;
        for(int i=0; i<n; i++){
            if(waitlist.peek()!=null){
                s = waitlist.poll();
                roster.add(s);
            } else {
                break;
            }
        }

        return roster;
    }
}

