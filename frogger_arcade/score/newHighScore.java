package frogger_arcade.score;
/**
 * @author psymp5
 */

import frogger_arcade.stage.GameOne;

import java.io.*;

/**
 * newHighScore class reads and writes  to highScore.txt to save and determine which is the highest score.
 */
public class newHighScore extends GameOne {

    int highScore;

    /**
     * Store Score simply just inputs the score into the txt file using a buffered Writer
     * @param score being the score from frog.getPoints
     */
    public void storeScore(int score) {

        try
             {
           BufferedWriter writer = new BufferedWriter(new FileWriter("swm-cw2/Frogger-Arcade-Game-master/frogger_arcade/highScore.txt", true));

           writer.newLine();
            writer.append("" + score);
            writer.close();
             } catch (IOException error)
        {
            System.err.printf("Could not write score inside file %s", error);
        }
    }

    /**
     * getHishScore determines which is the highest score in the txt file. So after has finished  playing the game it uses the bufferReader to check all scores and output the highest Score, using a while loop and if statement
     * @return  returns the highest score in the txt file
     */
    public int getHighScore(){
        try {
            BufferedReader bfreader = new BufferedReader(new FileReader("Frogger-Arcade-Game-master/frogger_arcade/highScore.txt"));

            String text = bfreader.readLine();

            while (text != null){
                try{
                int score = Integer.parseInt(text.trim());
                if ( score > highScore) {
                    highScore = score;
                }
                }  catch(NumberFormatException e1){
                    System.err.println("Error");
                }
                text = bfreader.readLine();
            }
            bfreader.close();

        } catch (IOException e) {
            System.out.printf("Error %s", e);
        }
    return highScore;
    }



}
