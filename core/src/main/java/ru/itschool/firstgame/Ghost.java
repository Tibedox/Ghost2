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
    boolean isAlive = true;

    Ghost(){
        vx = MathUtils.random(-8F, 8F);
        vy = MathUtils.random(-8F, 8F);
        width = MathUtils.random(50, 100);
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

    boolean isTapped(float tapX, float tapY) {
        if (x < tapX && tapX < x+width && y < tapY && tapY < y+height){
            return true;
        } else {
            return false;
        }
    }
}










