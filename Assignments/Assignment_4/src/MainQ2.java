/*
Author: Abhijeet Singh
Student ID: 1207508
Assignment: 4
Question: 2

Description:
This program extends the grading system with an `Analyzable` interface for grade analysis.
The `CourseGradesAnalyzable` class calculates the highest, lowest, and average grades.
It prompts the user for input and displays the analysis results.

How to run the program:
1. Compile using `javac MainQ2.java`.
2. Run using `java MainQ2`.
3. Follow the prompts to input scores for different assessments.
4. The program will display the grades, average, highest, and lowest scores.
*/
import java.util.Scanner;

interface Analyzable {
    double getAverage();
    LetterGrade getHighest();
    LetterGrade getLowest();
}


class CourseGradesAnalyzable extends CourseGrades implements Analyzable {
    private LetterGrade[] grades;

    public CourseGradesAnalyzable() {
        super();
        grades = new LetterGrade[4];
    }

    // Override methods from CourseGrades to store grades in this class's array
    @Override
    public void setLab(LetterGrade activity) {
        grades[0] = activity;
        super.setLab(activity);
    }

    @Override
    public void setPassFailExam(PassFailExam exam) {
        grades[1] = exam;
        super.setPassFailExam(exam);
    }

    @Override
    public void setEssay(Essay essay) {
        grades[2] = essay;
        super.setEssay(essay);
    }

    @Override
    public void setFinalExam(FinalExam exam) {
        grades[3] = exam;
        super.setFinalExam(exam);
    }

    @Override
    public double getAverage() {
        double total = 0;
        int count = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] != null) {
                total += grades[i].getScore();
                count++;
            }
        }

        return count > 0 ? total / count : 0;
    }

    @Override
    public LetterGrade getHighest() {
        LetterGrade highest = null;
        double highestScore = -1;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] != null && (highest == null || grades[i].getScore() > highestScore)) {
                highest = grades[i];
                highestScore = grades[i].getScore();
            }
        }

        return highest;
    }

    @Override
    public LetterGrade getLowest() {
        LetterGrade lowest = null;
        double lowestScore = 101; // Higher than any possible score

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] != null && (lowest == null || grades[i].getScore() < lowestScore)) {
                lowest = grades[i];
                lowestScore = grades[i].getScore();
            }
        }

        return lowest;
    }
}

public class MainQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Lab Activity
        LetterGrade lab = new LetterGrade();
        System.out.print("Enter the lab score: ");
        double labScore = scanner.nextDouble();
        lab.setScore(labScore);

        // Create a Pass/Fail Exam
        System.out.print("How many questions are on the exam? ");
        int pfQuestions = scanner.nextInt();
        System.out.print("How many questions did the student miss? ");
        int pfMissed = scanner.nextInt();
        System.out.print("Enter the minimum passing score for this test: ");
        double minPass = scanner.nextDouble();

        PassFailExam passFailExam = new PassFailExam(pfQuestions, pfMissed, minPass);
        System.out.println(passFailExam.toString());

        // Create an Essay
        Essay essay = new Essay();
        System.out.print("Enter points for grammar (0-30): ");
        essay.setGrammarPoints(scanner.nextInt());
        System.out.print("Enter points for spelling (0-20): ");
        essay.setSpellingPoints(scanner.nextInt());
        System.out.print("Enter points for length (0-20): ");
        essay.setLengthPoints(scanner.nextInt());
        System.out.print("Enter points for content (0-30): ");
        essay.setContentPoints(scanner.nextInt());

        // Create a Final Exam
        System.out.print("How many questions are on the final exam? ");
        int finalQuestions = scanner.nextInt();
        System.out.print("How many questions did the student miss? ");
        int finalMissed = scanner.nextInt();

        FinalExam finalExam = new FinalExam(finalQuestions, finalMissed);
        System.out.println(finalExam.toString());

        // Create and populate CourseGradesAnalyzable
        CourseGradesAnalyzable grades = new CourseGradesAnalyzable();
        grades.setLab(lab);
        grades.setPassFailExam(passFailExam);
        grades.setEssay(essay);
        grades.setFinalExam(finalExam);

        // Display the grades
        grades.print();

        // Display analysis results
        System.out.println("\nAnalysis Results:");
        System.out.println("-----------------");
        System.out.printf("Average Score: %.2f\n", grades.getAverage());

        LetterGrade highest = grades.getHighest();
        System.out.println("Highest Score: " + highest.getScore() + " (Grade: " + highest.getLetterGrade() + ")");

        LetterGrade lowest = grades.getLowest();
        System.out.println("Lowest Score: " + lowest.getScore() + " (Grade: " + lowest.getLetterGrade() + ")");

        scanner.close();
    }
}