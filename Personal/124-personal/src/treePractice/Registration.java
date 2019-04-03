package treePractice;

import java.util.ArrayList;

public class Registration {

    public static void main(String[] args){
        WaitList waitlist = new WaitList();
        waitlist.joinWaitList(new Student("Draven Reyer", 609377, "CS",3));
        waitlist.joinWaitList(new Student("Slavica Teke", 160610, "CS", 1));
        waitlist.joinWaitList(new Student("Alexandra Reis", 901211, "English", 4));
        waitlist.joinWaitList(new Student("Draven Reyer", 235054, "History", 2));
        waitlist.joinWaitList(new Student("Pallav Ahearn", 319131, "Music", 4));
        waitlist.joinWaitList(new Student("Pallav McQueen", 531242, "CS", 2));
        waitlist.joinWaitList(new Student("Victorius Wortham", 902373, "History", 3));
        waitlist.joinWaitList(new Student("Alexandra Reis", 234628, "CS", 4));
        waitlist.joinWaitList(new Student("Gaios Best", 131537, "AMS", 3));
        waitlist.joinWaitList(new Student("Wigbrand Spalding", 704970, "Physics", 4));

        ArrayList<Student> roster = waitlist.getClassRoster(5);
        for(Student s: roster){
            System.out.println(s);
        }
    }
}
