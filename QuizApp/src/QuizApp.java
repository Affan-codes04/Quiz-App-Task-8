import java.util.*;

class Question {
    String question, optionA, optionB, optionC, optionD;
    char correctOption;

    public Question(String question, String a, String b, String c, String d, char correctOption) {
        this.question = question;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctOption = Character.toUpperCase(correctOption);
    }

    public boolean ask(Scanner sc) {
        System.out.println("\n" + question);
        System.out.println("A) " + optionA);
        System.out.println("B) " + optionB);
        System.out.println("C) " + optionC);
        System.out.println("D) " + optionD);
        System.out.print("Your answer (A/B/C/D): ");

        char userAnswer = Character.toUpperCase(sc.next().charAt(0));
        return userAnswer == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();

        // Add your questions here
        questions.add(new Question("What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", 'C'));
        questions.add(new Question("Who developed Java?", "James Gosling", "Dennis Ritchie", "Guido van Rossum", "Bjarne Stroustrup", 'A'));
        questions.add(new Question("What is the output of 2 + 2 * 2?", "6", "8", "4", "10", 'A'));
        questions.add(new Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", 'B'));
        questions.add(new Question("What keyword is used to inherit a class in Java?", "inherits", "extends", "implements", "instanceof", 'B'));

        int score = 0;

        System.out.println("Welcome to the Ultimate Quiz Challenge");
        System.out.println("Answer the following questions:\n");

        for (Question q : questions) {
            if (q.ask(sc)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("You're a genius bruh!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Not bad! Respectable performance!");
        } else {
            System.out.println("Go study a bit more, you got this!");
        }

        sc.close();
    }
}
