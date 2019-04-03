package treeMapPractice;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StudentDirectory {


    public static void main(String args[]) {
        Student[] student = createStudents();
        Map<String, Student> stuMap = new TreeMap<>();

        for(int i=0; i<student.length; i++){
            String firstName = "";
            String studName = student[i].getName();
            for(char c : studName.toCharArray()) {
                if(c==' ')
                    break;
                else
                    firstName+=c;
            }
            stuMap.put(firstName, student[i]);
        }

        Set set = stuMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("The key is " + mentry.getKey() + " and the value is ");
            System.out.println(mentry.getValue());
        }


    }

    public static Student[] createStudents(){
        Student[] students = new Student[10];
        students[0] = new Student("Draven Reyer", 609377);
        students[1] = new Student("Slavica Teke", 160610);
        students[2] = new Student("Alexandra Reis", 901211);
        students[3] = new Student("Draven Loscar", 235054);
        students[4] = new Student("Pallav Ahearn", 319131);
        students[5] = new Student("Pallav McQueen", 531242);
        students[6] = new Student("Victorius Wortham", 902373);
        students[7] = new Student("Alexandra Reis", 234628);
        students[8] = new Student("Gaios Best", 131537);
        students[9] = new Student("Wigbrand Spalding", 704970);

        return students;
    }



}
