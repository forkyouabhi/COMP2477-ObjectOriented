import java.util.Scanner;
class LetterGrade {
    protected double score;
    protected char letterGrade;

    public LetterGrade() {
        score = 0.0;
        letterGrade = 'F';
    }

    public LetterGrade(double s) {
        setScore(s);
    }

    public void setScore(double s) {
        score = s;
        determineGrade();
    }

    public double getScore() {
        return score;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    protected void determineGrade() {
        if (score >= 90)
            letterGrade = 'A';
        else if (score >= 80)
            letterGrade = 'B';
        else if (score >= 70)
            letterGrade = 'C';
        else if (score >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';
    }
}

class Essay extends LetterGrade {
    private int grammarPoints;
    private int spellingPoints;
    private int lengthPoints;
    private int contentPoints;

    public Essay() {
        super();
        grammarPoints = 0;
        spellingPoints = 0;
        lengthPoints = 0;
        contentPoints = 0;
    }

    public void setGrammarPoints(int points) {
        if (points >= 0 && points <= 30)
            grammarPoints = points;
        calculateScore();
    }

    public void setSpellingPoints(int points) {
        if (points >= 0 && points <= 20)
            spellingPoints = points;
        calculateScore();
    }

    public void setLengthPoints(int points) {
        if (points >= 0 && points <= 20)
            lengthPoints = points;
        calculateScore();
    }

    public void setContentPoints(int points) {
        if (points >= 0 && points <= 30)
            contentPoints = points;
        calculateScore();
    }

    public int getGrammarPoints() {
        return grammarPoints;
    }

    public int getSpellingPoints() {
        return spellingPoints;
    }

    public int getLengthPoints() {
        return lengthPoints;
    }

    public int getContentPoints() {
        return contentPoints;
    }

    private void calculateScore() {
        score = grammarPoints + spellingPoints + lengthPoints + contentPoints;
        determineGrade();
    }
}


class PassFailExam extends LetterGrade {
    private int numQuestions;
    private int numMissed;
    private double minPassingScore;

    public PassFailExam() {
        super();
        numQuestions = 0;
        numMissed = 0;
        minPassingScore = 0.0;
    }

    public PassFailExam(int questions, int missed, double minScore) {
        set(questions, missed, minScore);
    }

    public void set(int questions, int missed, double minScore) {
        numQuestions = questions;
        numMissed = missed;
        minPassingScore = minScore;

        // Calculate the score
        double pointsEach = 100.0 / numQuestions;
        score = 100.0 - (missed * pointsEach);

        // Determine the letter grade
        if (score >= minPassingScore)
            letterGrade = 'P';
        else
            letterGrade = 'F';
    }

    public void setNumQuestions(int q) {
        numQuestions = q;
        set(numQuestions, numMissed, minPassingScore);
    }

    public void setNumMissed(int m) {
        numMissed = m;
        set(numQuestions, numMissed, minPassingScore);
    }

    public void setMinPassingScore(double min) {
        minPassingScore = min;
        set(numQuestions, numMissed, minPassingScore);
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public int getNumMissed() {
        return numMissed;
    }

    public double getMinPassingScore() {
        return minPassingScore;
    }

    public double getPointsEach() {
        return 100.0 / numQuestions;
    }

    @Override
    public String toString() {
        return "Each question counts " + getPointsEach() + " points.\n" +
                "The minimum passing score is " + minPassingScore + ".\n" +
                "The student's exam score is " + score + "\n" +
                "The student's grade is " + letterGrade;
    }
}

// FinalExam.java
class FinalExam extends LetterGrade {
    private int numQuestions;
    private int numMissed;

    public FinalExam() {
        super();
        numQuestions = 0;
        numMissed = 0;
    }

    public FinalExam(int questions, int missed) {
        set(questions, missed);
    }

    public void set(int questions, int missed) {
        numQuestions = questions;
        numMissed = missed;

        // Calculate the score
        double pointsEach = 100.0 / numQuestions;
        score = 100.0 - (missed * pointsEach);

        // Determine the letter grade
        determineGrade();
    }

    public void setNumQuestions(int q) {
        numQuestions = q;
        set(numQuestions, numMissed);
    }

    public void setNumMissed(int m) {
        numMissed = m;
        set(numQuestions, numMissed);
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public int getNumMissed() {
        return numMissed;
    }

    public double getPointsEach() {
        return 100.0 / numQuestions;
    }

    @Override
    public String toString() {
        return "Each question counts " + getPointsEach() + " points.\n" +
                "The exam score is " + score + "\n" +
                "The exam grade is " + letterGrade;
    }
}


class CourseGrades {
    private LetterGrade[] grades;

    public CourseGrades() {
        grades = new LetterGrade[4];
    }

    public void setLab(LetterGrade activity) {
        grades[0] = activity;
    }

    public void setPassFailExam(PassFailExam exam) {
        grades[1] = exam;
    }

    public void setEssay(Essay essay) {
        grades[2] = essay;
    }

    public void setFinalExam(FinalExam exam) {
        grades[3] = exam;
    }

    public void print() {
        System.out.println("\nCourse Grades:");
        System.out.println("-------------");

        if (grades[0] != null) {
            System.out.println("Lab Activity: Score = " + grades[0].getScore() +
                    ", Grade = " + grades[0].getLetterGrade());
        }

        if (grades[1] != null) {
            System.out.println("Pass/Fail Exam: Score = " + grades[1].getScore() +
                    ", Grade = " + grades[1].getLetterGrade());
        }

        if (grades[2] != null) {
            System.out.println("Essay: Score = " + grades[2].getScore() +
                    ", Grade = " + grades[2].getLetterGrade());
        }

        if (grades[3] != null) {
            System.out.println("Final Exam: Score = " + grades[3].getScore() +
                    ", Grade = " + grades[3].getLetterGrade());
        }
    }
}

public class MainQ1 {
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

        // Create and populate CourseGrades
        CourseGrades grades = new CourseGrades();
        grades.setLab(lab);
        grades.setPassFailExam(passFailExam);
        grades.setEssay(essay);
        grades.setFinalExam(finalExam);

        grades.print();

        scanner.close();
    }
}