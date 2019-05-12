package com.mona.shamsolebad.colorquiz;

import android.graphics.Color;

import java.util.Random;

public class Question {
    private final int[] colors = {Color.BLACK, Color.GRAY, Color.BLUE,
            Color.RED, Color.GREEN,
            Color.CYAN, Color.MAGENTA, Color.YELLOW};
    private final String[] colorsStr = {"Black", "Gray", "Blue", "Red", "Green", "Cyan", "Magenta", "Yellow"};
    private int leftColor;
    private int rightColor;
    private String questionLabel;
    private boolean isRightanswer;

    public Question() {
        generateQuestion();
    }

    public void generateQuestion() {


        Random rand = new Random();
        int leftRand = rand.nextInt(colors.length);
        leftColor = colors[leftRand];
        int rightRand = rand.nextInt(colors.length);
        while (rightRand == leftRand) {
            rightRand = rand.nextInt(colors.length);
        }
        rightColor = colors[rightRand];

        int[] choices = {leftRand, rightRand};
        int answerRand = rand.nextInt(choices.length);
        isRightanswer = answerRand != 0;
        int choice = choices[answerRand];
        questionLabel = colorsStr[choice];
    }

    public boolean isRightanswer() {
        return isRightanswer;
    }

    public int getLeftColor() {
        return leftColor;
    }

    public int getRightColor() {
        return rightColor;
    }

    public String getQuestionLabel() {
        return questionLabel;
    }
}
