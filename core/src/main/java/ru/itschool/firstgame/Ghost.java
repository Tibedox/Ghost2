package ru.itschool.firstgame;

import static ru.itschool.firstgame.Main.SCR_HEIGHT;
import static ru.itschool.firstgame.Main.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Ghost {
    float width;
    float height;
    float x = 0;
    float y = 0;
    float vx;
    float vy;

    Ghost(){
        vx = MathUtils.random(-10F, 10F);
        vy = MathUtils.random(-10F, 10F);
        width = MathUtils.random(10, 100);
        height = width / 0.8F;
    }

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
