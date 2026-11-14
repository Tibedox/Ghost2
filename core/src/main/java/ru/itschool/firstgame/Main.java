package ru.itschool.firstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    public static final int SCR_WIDTH = 1600, SCR_HEIGHT = 900;

    private SpriteBatch batch;
    private Texture imgGhost;
    private Texture imgBackGround;
    int width = 200;
    int height = 300;
    int x = 0;
    int y = 0;
    int vx = 10;
    int vy = 5;

    // Подготвка. Вызывается 1 раз
    @Override
    public void create() {
        batch = new SpriteBatch();
        imgGhost = new Texture("ghost.png");
        imgBackGround = new Texture("grave.jpg");
    }

    // Игровой цикл (отображение, получение данных от пользоваиеля, обработка). Бесконечное кол-во раз
    @Override
    public void render() {
        // события игры
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

        // отрисовка
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        batch.draw(imgGhost, x, y, width, height);
        batch.end();
    }

    // Освобождение ресурсов
    @Override
    public void dispose() {
        batch.dispose();
        imgGhost.dispose();
        imgBackGround.dispose();
    }
}
