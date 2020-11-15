package School;

import java.util.Random;

public class Wall implements Obstacle{
    int height;

    Wall(){
        Random rn = new Random();
        this.height = rn.nextInt(50);
    }
}