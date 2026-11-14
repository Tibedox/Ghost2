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
    Ghost ghost1;
    Ghost ghost2;

    // Подготвка. Вызывается 1 раз
    @Override
    public void create() {
        batch = new SpriteBatch();
        imgGhost = new Texture("ghost.png");
        imgBackGround = new Texture("grave.jpg");
        ghost1 = new Ghost();
        ghost1.x = 111;

        ghost2 = new Ghost();
        ghost2.vx  = 15;
    }

    // Игровой цикл (отображение, получение данных от пользоваиеля, обработка). Бесконечное кол-во раз
    @Override
    public void render() {
        // события игры
        ghost1.move();
        ghost2.move();

        // отрисовка
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        batch.draw(imgGhost, ghost1.x, ghost1.y, ghost1.width, ghost1.height);
        batch.draw(imgGhost, ghost2.x, ghost2.y, ghost2.width, ghost2.height);
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
