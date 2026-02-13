import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** Instance Variables */
  double moneyMade;
  String softwareUsed;
  ImageFilter[][] skillVisuals;
  String[][] skillDifficulty;
  String[][] skillNames;
  int[][] learningTime;
  
  
  /** Constructor */
  public SceneTwo(ImageFilter[][] skillVisuals, String[][] skillDifficulty, int[][] learningTime, String[][] skillNames) {
    this.skillVisuals = skillVisuals;
    this.skillDifficulty = skillDifficulty;
    this.learningTime = learningTime;
    this.skillNames = skillNames;
    softwareUsed = "davinci";
    
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    clear("white");
    drawText("The second thing I do is..", 100,130);
    wait(2);
    drawText("Video editing!!!", 100, 130);
    drawImage("editing.jpg", 100, 170, 200);
    wait(2);

    drawText("I have been learning", 100,130);
    drawText("video editing for about 2 months", 100,170);
    wait(2);

    drawText("The software I use is " + softwareUsed, 80,130);
    drawImage("davinci.png", 100, 170, 150);
    wait(2);

    drawText("The amount of money I made so far is ", 10,130);
    wait(2);

    drawText("$25.40", 150,130);
    ImageFilter moneyImage = new ImageFilter("money.png");
    drawImage(moneyImage, 100, 170, 150);
    pause(3);
    clear("white");
    //applying saturation effect for better visuals 
    moneyImage.saturate(1);
    drawImage(moneyImage, 100, 170, 150);
    wait(1);

    drawText("Some skills I learned from video ", 10,110);
    drawText("editing are:  ", 10,130);
    wait(1);

    pause(1);
    //showing each skill with flashing red effect 
    drawOutSkills(skillVisuals,skillDifficulty,skillNames,learningTime);
    drawText(findHardestSkill(learningTime, skillNames), 10,100);
    drawText("As it is one of the hardest ", 10,130);
    drawText("video editing skill that I learned", 10,160);
    wait(4);

    //conclusion screen
    drawText("In conclusion: ", 80,150);
    pause(1);
    drawText("1. I like to play roblox ", 80,170);
    pause(2);
    drawText("2. I like video editing ", 80,190);
    wait(2);

    drawText("The end :) ", 80,150);

  }

   /**
   * Helper method that helps make the code look cleaner 
   */
  public void wait(int sec){
    pause(sec);
    clear("white");
  }
  //displays each video editing skill, and does red flashes 
  public void drawOutSkills(ImageFilter[][] arr, String[][] skillDifficulty,String[][] skillNames,int[][] learningTime) {
    for(int r = 0; r < arr.length; r++){
      for(int c = 0; c < arr[0].length; c++){
        drawImage(arr[r][c], 120, 170, 150);
        drawText("Skill name: " + skillNames[r][c], 70, 70);
        drawText("Difficulty: " + skillDifficulty[r][c], 70, 90);
        drawText("Learning time: " + learningTime[r][c] + " hours", 70, 110);

        wait(1);


        ImageFilter newImage = arr[r][c];
        newImage.redColor();
        clear("white");
        drawImage(newImage, 120, 170, 150);
        drawText("Skill name: " + skillNames[r][c], 70, 70);
        drawText("Difficulty: " + skillDifficulty[r][c], 70, 90);
        drawText("Learning time: " + learningTime[r][c] + " hours", 70, 110);

        pause(1);
        clear("white");
      }
    }
  }
  //finds the skill that took the most hours to learn 
  public String findHardestSkill(int[][] hours, String[][] names){
    int maxHours = 0;
    String currentName = "";
    for(int r = 0; r < learningTime.length; r++){
      for(int c = 0; c < learningTime[0].length; c++){
        if(hours[r][c] > maxHours){
          maxHours = learningTime[r][c];
          currentName = skillNames[r][c];
        }
      }
    }
    return "I spent " + maxHours + " hours learning " + currentName;  
  }
}
