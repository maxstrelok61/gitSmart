package level2;

import java.util.Random;

public class wall {
    int height;

    wall (){
        Random rn = new Random();
        this.height = rn.nextInt(50);
    }
}
