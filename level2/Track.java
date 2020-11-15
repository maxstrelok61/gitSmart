package School;

import java.util.Random;

public class Track implements Obstacle{

    int lonG;

    Track(){
        Random rn = new Random();
        this.lonG = rn.nextInt(50);
    }
}