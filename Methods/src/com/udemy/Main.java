package com.udemy;

public class Main {

    public static void main(String[] args) {
	    calculateScore(true, 800, 5, 100);
        calculateScore(true, 10000, 8, 200);

        displayHighScorePosition("Chris", calculateHighScorePosition(1500));
        displayHighScorePosition("Chris", calculateHighScorePosition(900));
        displayHighScorePosition("Chris", calculateHighScorePosition(500));
        displayHighScorePosition("Chris", calculateHighScorePosition(50));

        calculateScore("John", 10);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position + " on the high score table");
    }

    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) {
            return 1;
        } else if (score >= 500 && score < 1000) {
            return 2;
        } else if (score >= 100 && score < 500) {
            return 3;
        } else {
            return 4;
        }
    }

    public static int calculateScore(String name, int score) {
        System.out.println("Player " + name + " scored " + score + " points");
        return score * 1000;
    }
}
