package ru.itschool.firstgame;

import static ru.itschool.firstgame.Main.SCR_HEIGHT;
import static ru.itschool.firstgame.Main.SCR_WIDTH;

public class Ghost {
    int width = 200;
    int height = 300;
    int x = 0;
    int y = 0;
    int vx = 10;
    int vy = 5;

    void move(){
        x += vx;
        y += vy;
        /*if(x>SCR_WIDTH) x=-width;
        if(y>SCR_HEIGHT) y=-height;*/
        if(x>SCR_WIDTH-width || x<0) {
            vx = -vx;
        }
        if(y>SCR_HEIGHT-height || y<0) {
            vy = -vy;
        }
    }
}
