import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor

     /**
   * Setting up the 2d arrays which I use in my scene files 
   */
    String[][] robloxGames = {
      {"BedWars", "Mimic", "Doors"},
      {"Brookhaven", "Arsenal", "Murder Mystery 2"},
      {"Build a Boat", "Adopt Me", "Blade Ball"}
    };
    String[][] gameDifficulties = {
      {"Hard", "Extreme", "Medium"},
      {"Easy", "Medium", "Easy"},
      {"Medium", "Impossible", "Easy"}
    };
    int[][] hoursPerGame = {
      {12, 47, 64},
      {3, 93, 102},
      {21, 419, 16}
    };
    ImageFilter[][] gameImages = {
      {new ImageFilter("bedwars.png"), new ImageFilter("mimic.jpg"), new ImageFilter("doors.png")},
      {new ImageFilter("brookhaven.png"), new ImageFilter("arsenal.png"), new ImageFilter("mm2.png")},
      {new ImageFilter("buildaboat.jpg"), new ImageFilter("adoptme.png"), new ImageFilter("bladeball.jpg")}
    };
    
    ImageFilter[][] videoEditSkills = {
      {new ImageFilter("motiongraphics.jpeg"), new ImageFilter("keyframe.png")},
      {new ImageFilter("colorgrading.jpeg"), new ImageFilter("clipping.png")}
    };
    String[][] skillDifficulty = {
      {"Hard", "Medium"},
      {"Medium", "Easy"}
    };
    int[][] timeTookToLearn = {
      {4, 1},
      {2, 1}
    };
    String[][] skillNames = {
      {"Motion Graphics", "Keyframe Animations"},
      {"Color Grading", "Cutting videos"}
    };
    

    
    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(robloxGames,gameImages,hoursPerGame,gameDifficulties,"gameImages.txt");
    SceneTwo scene2 = new SceneTwo(videoEditSkills, skillDifficulty, timeTookToLearn, skillNames);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater, in order of arguments
    //Theater.playScenes(scene1, scene2);
    Theater.playScenes(scene1, scene2);
    
  }
}
