
import java.util.Scanner;

/**
 * @author Bonnie Chan
 */
public class GradeCalculator {

    public static void main(String[] args) {
        System.out.println("Welcome to GradeCalculator!");
        System.out.println();

        Scanner s = new Scanner(System.in);

        System.out.print("Please enter the number of students: ");
        int numStudents = s.nextInt();

        System.out.print("Please enter the number of exams   : ");
        int numExams = s.nextInt();

        System.out.println();
        System.out.println("--------------------------------------------------------");

        double classSum = 0; // sum of student averages
        double classMin = 100; // min of student averages
        double classMax = 0; // max of student averages

        // for each student
        for (int studentIndex = 0; studentIndex < numStudents; studentIndex++) {
            System.out.print("Enter student " + ((studentIndex+1)) + "'s first and last name   : ");
            String name = s.next();
            name += " " + s.next();

            int studentSum = 0; // sum of current student's exam scores
            int studentMin = 100; // min of current student's exam scores
            int studentMax = 0; // max of current student's exam scores

            System.out.print("Enter exam scores (separated by a space): ");

            // for current student's exams
            for (int examIndex = 0; examIndex < numExams; examIndex++) {
                int score = s.nextInt();
                if (score < 0 || score > 100) {
                    // bad score input, restart the loop, and reset variables
                    examIndex = -1; // set to -1 so examIndex is reset to 0; ensures full loop for reentered input of correct exam scores
                    studentSum = 0;
                    s.nextLine();
                    studentMin = 100;
                    studentMax = 0;
                    System.out.print("Invalid exam scores, reenter: ");
                } else {
                    // valid score input, keep going through loop
                    studentSum += score; // adding current score to studentSum
                    if (score < studentMin) {
                        // new current studentMin
                        studentMin = score;
                    }
                    if (score > studentMax) {
                        // new current studentMax
                        studentMax = score;
                    }
                }
            }

            double studentAverage = (double) studentSum / numExams; // current student average score
            classSum += studentAverage; // adding current studentAverage to classSum
            if (studentAverage < classMin) {
                // new classMin
                classMin = studentAverage;
            }
            if (studentAverage > classMax) {
                // new classMax
                classMax = studentAverage;
            }

            System.out.println();
            System.out.println("Grade statistics for " + name);
            System.out.println("  Average     : " + studentAverage);

            // determining current student's grade, numStar, and stars
            String grade;
            int numStar;
            String stars;
            if (studentAverage >= 90) {
                // output if studentAverage between 90-100
                grade = "A";
                numStar = 4;
                stars = "****";
            } else if (studentAverage >= 80) {
                // output if studentAverage between 80-89
                grade = "B";
                numStar = 3;
                stars = "***";
            } else if (studentAverage >= 70) {
                //output if studentAverage between 70-79
                grade = "C";
                numStar = 2;
                stars = "**";
            } else if (studentAverage >= 60) {
                // output if studentAverage between 60-69
                grade = "D";
                numStar = 1;
                stars = "*";
            } else {
                // output if studentAverage below 60
                grade = "F";
                numStar = 0;
                stars = "";
            }

            System.out.println("  Letter grade: " + grade);
            System.out.println("  " + name + " gets " + numStar + " stars! " + stars);

            System.out.println();
            System.out.println("--------------------------------------------------------");

        }

        double classAverage = classSum / numStudents; // calculate average of all studentAverages

        System.out.println("Class statistics:");

        System.out.println("  Average: " + classAverage);
        System.out.println("  Lowest : " + classMin);
        System.out.println("  Highest: " + classMax);

        System.out.println();
        System.out.println("Done. Good bye!");
    }
}
