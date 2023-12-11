package simple.coursegrades;

import java.util.Scanner;

public class CourseGrades {

    // weightage constants
    private static final double QUIZ_WEIGHTAGE = 0.15;
    private static final double TEST_WEIGHTAGE = 0.2;
    private static final double PROGRAM_WEIGHTAGE = 0.25;
    private static final double PROJECT_WEIGHTAGE = 0.4;

    // scholarship constants
    private static final double SCHOLARSHIP_85_89 = 250.0;
    private static final double SCHOLARSHIP_90_94 = 500.0;
    private static final double SCHOLARSHIP_95_100 = 750.0;

    // arrays to store student data
    private static String[] studentNames;
    private static double[] studentAvg;
    private static char[] letterGrades;
    private static double[] scholarshipAmounts;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ask for number of courses
        System.out.print("\nEnter number of courses: ");
        int numCourses = input.nextInt();
        input.nextLine(); // consume newline character

        // arrays to store course data
        String[] courseNames = new String[numCourses];
        int[] numStudentsPerCourse = new int[numCourses];
        double[] courseAvgs = new double[numCourses];
        int[] numStudentsAbove70 = new int[numCourses];
        double[] highestAvg = new double[numCourses];
        double[] lowestAvg = new double[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // ask for course and section
            System.out.print("\nEnter course name and section: ");
            String courseInfo = input.nextLine();

            // ask for number of students
            System.out.print("Enter number of students in course: ");
            int numStudents = input.nextInt();
            input.nextLine(); // consume newline character

            // student data arrays
            studentNames = new String[numStudents];
            studentAvg = new double[numStudents];
            letterGrades = new char[numStudents];
            scholarshipAmounts = new double[numStudents];

            // ask for student's data
            for (int j = 0; j < numStudents; j++) {
                System.out.println("\nEnter data for student #" + (j + 1) + ":");
                System.out.print("Enter student's first name: ");
                String firstName = input.nextLine();
                System.out.print("Enter student's last name: ");
                String lastName = input.nextLine();
                studentNames[j] = firstName + " " + lastName;

                // ask for quiz score
                System.out.print("Enter quiz score (0-100): ");
                double quizScore = input.nextDouble();
                if (quizScore < 0 || quizScore > 100) {
                    System.out.println("Invalid score. Skipping student.");
                    continue;
                }

                // ask for test score
                System.out.print("Enter test score (0-100): ");
                double testScore = input.nextDouble();
                if (testScore < 0 || testScore > 100) {
                    System.out.println("Invalid score. Skipping student.");
                    continue;
                }

                // ask for program score
                System.out.print("Enter program score (0-100): ");
                double programScore = input.nextDouble();
                if (programScore < 0 || programScore > 100) {
                    System.out.println("Invalid score. Skipping student.");
                    continue;
                }
                // ask for project score
                System.out.print("Enter project score (0-100): ");
                double projectScore = input.nextDouble();
                if (projectScore < 0 || projectScore > 100) {
                    System.out.println("Invalid score. Skipping student.");
                    continue;
                }

                // calculate student average 
                double avgScore = (quizScore * QUIZ_WEIGHTAGE) + (testScore * TEST_WEIGHTAGE) +
                        (programScore * PROGRAM_WEIGHTAGE) + (projectScore * PROJECT_WEIGHTAGE);
                studentAvg[j] = avgScore;

                // calculate letter grades
                if (avgScore >= 90) {
                    letterGrades[j] = 'A';
                } else if (avgScore >= 80) {
                    letterGrades[j] = 'B';
                } else if (avgScore >= 70) {
                    letterGrades[j] = 'C';
                } else if (avgScore >= 60) {
                    letterGrades[j] = 'D';
                } else {
                    letterGrades[j] = 'F';
                }

                // calculate scholarship amounts
                if (avgScore >= 95) {
                    scholarshipAmounts[j] = SCHOLARSHIP_95_100;
                } else if (avgScore >= 90) {
                    scholarshipAmounts[j] = SCHOLARSHIP_90_94;
                } else if (avgScore >= 85) {
                    scholarshipAmounts[j] = SCHOLARSHIP_85_89;
                } else {
                    scholarshipAmounts[j] = 0.0;
                }
            }

            // calculate course average score
            double courseTotal = 0.0;
            int numStudentsAbove70ForCourse = 0;
            double highestAvgForCourse = Double.MIN_VALUE;
            double lowestAvgForCourse = Double.MAX_VALUE;
            for (int j = 0; j < numStudents; j++) {
                courseTotal += studentAvg[j];
                if (studentAvg[j] >= 70) {
                    numStudentsAbove70ForCourse++;
                }
                if (studentAvg[j] > highestAvgForCourse) {
                    highestAvgForCourse = studentAvg[j];
                }
                if (studentAvg[j] < lowestAvgForCourse) {
                    lowestAvgForCourse = studentAvg[j];
                }
            }
            double courseAvg = courseTotal / numStudents;
            courseAvgs[i] = courseAvg;
            numStudentsAbove70[i] = numStudentsAbove70ForCourse;
            highestAvg[i] = highestAvgForCourse;
            lowestAvg[i] = lowestAvgForCourse;

            // print course results
            System.out.println("\nCourse Report for " + courseInfo);
            System.out.println("-------------------------------");
            System.out.println("Number of students: " + numStudents);
            System.out.println("Course average: " + courseAvg);
            System.out.println("Number of students above 70: " + numStudentsAbove70ForCourse);
            System.out.println("Highest average: " + highestAvgForCourse);
            System.out.println("Lowest average: " + lowestAvgForCourse);
        }

        // print overall results
        System.out.println("\nOverall Report");
        System.out.println("--------------");
        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nData for student #" + (i + 1) + ":");
            System.out.println("Name: " + studentNames[i]);
            System.out.printf("Average score: %.2f\n", studentAvg[i]);
            System.out.println("Letter grade: " + letterGrades[i]);
            System.out.printf("Scholarship amount: $%.2f\n", scholarshipAmounts[i]);
        }
    }

}