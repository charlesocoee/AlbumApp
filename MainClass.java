package cs3.a;
import java.util.Scanner;
/**
 * Main class gathers data, computes it, 
 * and then displays it, while using the
 * AlbumTrack class for the user input.
 * @author $Charles Owens
 */
public class MainClass {
    private int longestTrack;
    private int shortestTrack;
    private int albumLength;
    private int avgTrackLength;
    private int sum;
    public AlbumTrack[] song;
    public static final int numberOfTracks = 13;
    

    
    public void getData(){
        Scanner keyboard = new Scanner(System.in);
        song = new AlbumTrack[numberOfTracks];
        for(int i = 1; i < numberOfTracks; i++){
            song[i] = new AlbumTrack();
            System.out.println("Track " + i + ":");
            song[i].readInput();
            System.out.println();
        }
    }
    
    public void computeStats(){
        int nextTrack = song[1].getTotalLength();
        longestTrack = nextTrack;
        sum = nextTrack;       
        for(int i = 2; i < numberOfTracks; i++){
            nextTrack = song[i].getTotalLength();
            sum = sum + nextTrack;
            if(nextTrack > longestTrack)
                longestTrack = nextTrack;
        }
        
        avgTrackLength = sum / (numberOfTracks - 1);
        
        nextTrack = song[1].getTotalLength();
        shortestTrack = nextTrack;
        for(int i = 2; i < numberOfTracks; i++){
           nextTrack = song[i].getTotalLength();
           if(nextTrack < shortestTrack)
               shortestTrack = nextTrack;
        }
    }
    
    
    public void displayResults(){
        //Shortest Track
        for(int i = 1; i < numberOfTracks; i++){
            int nextTrack = song[i].getTotalLength();
            if(nextTrack == shortestTrack)
            {  
                System.out.println("The shortest track is #" + i + " at ");
                song[i].writeOutput();
            }
        }

        //Longest Track
        for(int i = 1; i < numberOfTracks; i++){
            int nextTrack = song[i].getTotalLength();
            if(nextTrack == longestTrack)
            {  
                System.out.println("The longest track is #" + i + " at ");
                song[i].writeOutput();
            }
        }
        
        //Length of Album
        albumLength = sum;
        int minute = albumLength/60;
        int sec = albumLength%60;
        System.out.println("The total length of the album is: ");
        if(sec < 10)
            System.out.println(minute + ":" + "0" + sec);  
        else
            System.out.println(minute + ":" + sec);
       
        //Average Length of each track
        minute = avgTrackLength/60;
        sec = avgTrackLength%60;
        System.out.println("The average length of a track is: ");
        if(sec < 10)
            System.out.println(minute + ":" + "0" + sec);  
        else
            System.out.println(minute + ":" + sec);        
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Charles Owens' Album Length Calculator\n"
                + "Please enter all track lengths in minutes and seconds separated by a space.\n");
        OwensAssign6 nirvana = new OwensAssign6();
        nirvana.getData();
        nirvana.computeStats();
        nirvana.displayResults();       
    } 
}


