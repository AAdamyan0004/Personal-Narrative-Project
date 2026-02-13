import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a pixelated image
 */
public class ImageFilter extends ImagePlus {

  /*
   * Calls the superclass constructor to initialize pixels
   */
  public ImageFilter(String filename) {
    super(filename);
  }
  
  /*
   * Applies a pixelate filter to each Pixel object by dividing the image into a grid
   * of equal-sized rectangular regions and setting the color of each Pixel object in
   * a region to the color of the first Pixel object in the region
   */
  public void pixelate(int gridSize) {
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 0; row < pixels.length; row+=gridSize){
      for(int col = 0; col < pixels[0].length; col+=gridSize){
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);
        
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;
        int count = 0;

        for(int r = row; r < endRow; r++){
          for(int c = col; c < endCol; c++){
            totalRed+=pixels[r][c].getRed();
            totalGreen+=pixels[r][c].getGreen();
            totalBlue+=pixels[r][c].getBlue();
            count++;
          }
        }

        int averageRed = totalRed/count;
        int averageGreen = totalGreen/count;
        int averageBlue = totalBlue/count;
        
        for(int r = row; r < endRow; r++){
          for(int c = col; c < endCol; c++){
            pixels[r][c].setRed(averageRed);
            pixels[r][c].setGreen(averageGreen);
            pixels[r][c].setBlue(averageBlue);
          }
        }
      }
    }
  }
  
 public void saturate(int factor) {
    Pixel[][] pixels = getImagePixels();

    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[0].length; col++){
        int redcolor = pixels[row][col].getRed();
        int greencolor = pixels[row][col].getGreen();
        int bluecolor = pixels[row][col].getBlue();
        int averagecolor = redcolor + greencolor + bluecolor;
        averagecolor/=3;
        int grayscale = averagecolor + (averagecolor - 255) * factor;
        int newRed = 2*grayscale - redcolor;
        int newGreen = 2*grayscale - greencolor;
        int newBlue = 2*grayscale - bluecolor;
        if(newRed > 255){
          newRed = 255;
        }
        if(newGreen > 255){
          newGreen = 255;
        }
        if(newBlue > 255){
          newBlue = 255;
        }
        pixels[row][col].setRed(newRed);
        pixels[row][col].setGreen(newGreen);
        pixels[row][col].setBlue(newBlue);
      }
    }
 }
 public void colorShift(int value) {
   Pixel[][] pixels = getPixelsFromImage();
   for(int r = 0; r < pixels.length; r++){
     for(int c = 0; c < pixels[0].length; c++){
       Pixel currentPixel = pixels[r][c];
       int currentRed = (int)(currentPixel.getRed() + value);
       int currentBlue = (int)(currentPixel.getBlue() + value);
       int currentGreen =(int)(currentPixel.getGreen() + value);

       currentPixel.setRed(currentRed);
       currentPixel.setBlue(currentBlue);
       currentPixel.setGreen(currentGreen);
     }
   }
 }
 public void redColor(){
   Pixel[][] pixels = getPixelsFromImage();
   for(int r = 0; r < pixels.length; r++){
     for(int c = 0; c < pixels[0].length; c++){
       pixels[r][c].setRed(255);
       pixels[r][c].setGreen(0);
       pixels[r][c].setBlue(0);
     }
   }
 } 
}
