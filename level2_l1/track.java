package level2;

import java.util.Random;

public class track {

    int lonG;

    track (){
        Random rn = new Random();
        this.lonG = rn.nextInt(50);
    }
}
