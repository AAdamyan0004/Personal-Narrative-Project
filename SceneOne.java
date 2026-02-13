import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {
   /** 
   * Setting up the instance variables that store
   * - game names
   * - difficulty levels
   * - images for each game
   * - hours played per game
   */
  String[][] names;
  String[][] difficulties;
  ImageFilter[][] images;
  int[][] hours;
  String fileName;
  int hoursPlayed;
  int startedPlaying;
  
  /** Constructor */
  public SceneOne(String[][] names, ImageFilter[][] images, int[][] hours, String[][] difficulties, String fileName) {
    this.names = names;
    this.images = images;
    this.hours = hours;
    this.difficulties = difficulties;
    this.fileName = fileName;
    //playtime info 
    hoursPlayed = 600;
    startedPlaying = 2023;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {

    //scene intro with sound
    clear("white");
    playSound("comedy.wav");
    drawText("2 core things in my life!", 105,200);
    wait(4);

    //question text
    drawText("Are you ready???", 110, 200);
    wait(3);

    //roblox intro text
    drawText("1. I play roblox :) ", 105,200);
    pause(2);

    drawText("I played it for almost 700 hours", 60,230);
    pause(0.5);
    clear("white");

    //animated text with . .. ...
    drawText("1. I play roblox :) ", 105,200);
    drawText("I played it for almost 700 hours.", 60,230);
    pause(1);
    drawText("1. I play roblox :) ", 105,200);
    drawText("I played it for almost 700 hours..", 60,230);
    pause(1);
   
    drawText("1. I play roblox :) ", 105,200);
    drawText("I played it for almost 700 hours...", 60,230);
    pause(1);
    clear("white");
    pause(1);
    //transition to my favorite games 
    drawText("Here are my favorite games !", 100,230);
    pause(2);
    clear("white");

    //countdown animation 
    for(int i = 5; i >= 0; i--){
      drawText("In " + i, 200,200);
      pause(1);
      clear("white");
    }
    wait(1);
    
    //showing each game image with their info 
    drawOutImages(images, names, difficulties);
    wait(1);
    
    drawText("After calculating the amount of hours ",20,120);
    drawText("I spent on each game...", 20, 150);

    wait(2);
    drawText("I found out that",100,120);
    wait(3);
    //shocked image
    ImageFilter shocked = new ImageFilter("shocked.png");
    drawText(findLongestHours(hours, names), 60, 120);
    drawImage(shocked, 100,200,200);
    wait(1);

    //pixelate effect
    for(int i = 1; i < 12; i++){
      shocked.pixelate(i);
      drawText(findLongestHours(hours, names), 60, 120);
      drawImage(shocked, 100,200,200);
      pause(0.1);
    }
    wait(3);

    //text and audio whuch shows how much money I spent on the game
    drawText("Not only that..",100,120);
    playSound("Shocked-Sound-Effect-Shravan-10-Sound-Effects.wav");
    pause(1.5);
    clear("white");
    drawImage("robux.png", 100, 200, 100);
    drawText("I spent over $100 on the game ", 80, 90);
    drawText("in just 1 year!!!", 80, 130);
    wait(3);
    
    drawText("Best if we just move ",100,120);
    drawText("on to something else..",100,140);
    drawImage("shy.png", 100,200,200);
    wait(3);
    
  }

  //RETURN METHOD
  //returns a sentance showing the game with the highest number of hours 
  public String findLongestHours(int[][] hours, String[][] names){
    int maxHours = 0;
    String currentName = "";
    for(int r = 0; r < hours.length; r++){
      for(int c = 0; c < hours[0].length; c++){
        if(hours[r][c] > maxHours){
          maxHours = hours[r][c];
          currentName = names[r][c];
        }
      }
    }
    return "I played " + currentName + " for " + maxHours + " hours";    
  }
  //VOID METHOD 
  //shows each game image, also applies a colorshift effect 
  public void drawOutImages(ImageFilter[][] images, String[][] names, String[][] difficulties){
    for(int r = 0; r < images.length; r++){
      for(int c = 0; c < images[0].length; c++){
        clear("white");
        drawImage(images[r][c], 120, 170, 150);
        drawText("Game name: " + names[r][c], 70, 120);
        drawText("Difficulty: " + difficulties[r][c], 70, 90);
        pause(1);

        ImageFilter newImage = images[r][c];
        newImage.colorShift(100);

        playSound("oof.wav");
        clear("white");
        
        drawImage(newImage, 120, 170,150);
        drawText("Game name: " + names[r][c], 70, 120);
        drawText("Difficulty: " + difficulties[r][c], 70, 90);
        wait(1);
      }
    }
  }
    /**
   * Helper method that helps clean up my code
   */
  public void wait(int sec){
    pause(sec);
    clear("white");
  }
  
}
