package cs3.a;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * This class takes user input of minutes
 * and seconds. It also performs necessary
 * conversions.
 * @author $Charles Owens
 */
public class AlbumTrack {
    
    private int minute;
    private int second;
    
    public AlbumTrack(){
        minute = 0;
        second = 0;
    }
    
    public AlbumTrack(int initialMinute, int initialSecond){
        set(initialMinute, initialSecond);
    }
    
    public void set(int newMinute, int newSecond){
        minute = newMinute;
        second = newSecond;
    }
    
    public void readInput(){
        Scanner keyboard = new Scanner(System.in);
        minute = keyboard.nextInt();
        second = keyboard.nextInt();
    }
    
    public int getMinute(){
        return minute;
    }
    
    public int getMinuteConverted(){
        return (minute * 60);
    }
    
    public int getSecond(){
        return second;
    }
    
    public int getTotalLength(){
        return (minute * 60) + second;
    }
    
    public void writeOutput(){
        int length = this.getTotalLength();
        int minute = length/60;
        int sec = length%60;
        if(sec < 10)
            System.out.println(minute + ":" + "0" + sec);  
        else
            System.out.println(minute + ":" + sec);
    }
}