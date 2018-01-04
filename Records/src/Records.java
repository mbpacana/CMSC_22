    /*	check remove....
 *	Lab 10: File Reading and Writing with Lists
 *	performed by Michael Loewe L. Alivio, Michael Ervin B. Pacana, and Juan Carlos T. Roldan
 *  parts of code may be copied from Sir Nico Enego's file reading and writing repository
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;

public class Records {
    public static void main(String[] args){

        List<Student> record = new LinkedList<Student>();
        Student temp = new Student();
        Scanner in = new Scanner(System.in);
        BufferedReader br = null;
        try {
            String sCurrentLine, tFirstName, tLastName,tStudNum, tCourse;
            int tYear;
            char tMiddleInit;

            br = new BufferedReader(new FileReader("db.txt"));

            while ((sCurrentLine = br.readLine()) != null && sCurrentLine.charAt(0) != '\n') {
                 tStudNum = sCurrentLine;
                tFirstName = (sCurrentLine = br.readLine());
            	tMiddleInit = ( (sCurrentLine = br.readLine()).charAt(0) );
            	tLastName = (sCurrentLine = br.readLine());
            	tCourse = (sCurrentLine = br.readLine());
            	tYear = (Integer.parseInt(sCurrentLine = br.readLine()));
                record.add(new Student(tStudNum, tFirstName, tMiddleInit,tLastName,tCourse,tYear));
            }

            display(record);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        int choice;
        String tempString;
        do{
            System.out.println("\t\tMenu\n\t1. Register student\n\t2. Search for a student\n\t3. Remove student from list\n\t4. Save\n\t5. Display list\n\t6. Update\n\t7. Exit");
            choice = in.nextInt();
            switch(choice){
                case 1:
                    Scanner ln = new Scanner(System.in); //using a different scanner object flushes the newline character
                    temp.setStudentNumber(ln.nextLine());
                    temp.setFirstName(ln.nextLine());
                    temp.setMiddleInitial(ln.nextLine().charAt(0));
                    temp.setLastName(ln.nextLine());
                    temp.setCourse(ln.nextLine());
                    try{
                        temp.setYearLevel(Integer.parseInt(ln.next()));
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                    }

                    record.add(temp);
                    System.out.println("Student added!");
                    display(record);
                    break;

                case 2:
                    in.nextLine();
                    tempString = in.nextLine();

                    for(Student l : record){
                        if(tempString.compareTo(l.getStudentNumber()) == 0){
                            System.out.println(l);
                        }
                    }
                    break;

                case 3:
                    tempString = in.next();
                    int removeIndex = -1, i = 0;
                    for(Student l : record){
                        if(tempString.compareTo(l.getStudentNumber()) == 0){
                            removeIndex = i;
                        }
                        i++;
                    }
                    if(i != record.size() && record.size() != 0){
                        record.remove(removeIndex);
                    }
                    display(record);
                    break;

                case 4:
                    try {
                        File file = new File("db.txt");
                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                        for(Student l : record){
                            String output = l.toString(true);
                            bw.write(output);     //one write function ought to be enough...
                            bw.newLine();
                        }

                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Displaying contents of the student list:");
                    display(record);
                    break;
                case 6:
                    Scanner ln2 = new Scanner(System.in);
                    System.out.println("Enter Student Number: ");
                    tempString = ln2.nextLine();
                    for(Student l : record){
                        if(l.getStudentNumber().compareTo(tempString) == 0){
                            int updateChoice = 0;
                            do{
                                System.out.println("\t\tUpdate Menu\n\t1. Change first name\n\t2. Change middle initial\n\t3. Change last name\n\t4. Change Program\n\t5. Change year level\n\t6. I'm finished");
                                updateChoice = in.nextInt();
                                switch(updateChoice){
                                    case 1:
                                        System.out.println("Enter name: ");
                                        l.setFirstName(ln2.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("Enter initial: ");
                                        l.setMiddleInitial(ln2.nextLine().charAt(0));
                                        break;
                                    case 3:
                                        System.out.println("Enter name: ");
                                        l.setLastName(ln2.nextLine());
                                        break;
                                    case 4:
                                        System.out.println("Enter course: ");
                                        l.setCourse(ln2.nextLine());
                                        break;
                                    case 5:
                                        System.out.println("Enter year: ");
                                        l.setYearLevel(ln2.nextInt());
                                        break;
                                    case 6:
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                }
                                System.out.println(l);
                            }while(updateChoice != 6);
                            System.out.println("Necessary fields changed.");
                        }
                    }

                    break;
                case 7:
                    System.out.println("Exiting..\n");
                    break;
                default:
                    System.out.print("Invalid Choice\n");
            }
        } while(choice != 7);
    }

    public static void display(List<Student> l){
        for(Student ln : l){
            System.out.println(ln);
        }
    }
}