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
    int ghostCount = 400;
    Ghost[] ghosts = new Ghost[ghostCount];

    // Подготвка. Вызывается 1 раз
    @Override
    public void create() {
        batch = new SpriteBatch();
        imgGhost = new Texture("ghost.png");
        imgBackGround = new Texture("grave.jpg");
        for (int i = 0; i < ghostCount; i++) {
            ghosts[i] = new Ghost();
        }
    }

    // Игровой цикл (отображение, получение данных от пользоваиеля, обработка). Бесконечное кол-во раз
    @Override
    public void render() {
        // события игры
        for (int i = 0; i < ghostCount; i++) {
            Ghost ghost = ghosts[i];
            ghost.move();
        }
        for (int i = 0; i < ghostCount; i++) {
            ghosts[i].move();
        }


        // отрисовка
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for (int i = 0; i < ghostCount; i++) {
            Ghost ghost = ghosts[i];
            batch.draw(imgGhost, ghost.x, ghost.y, ghost.width, ghost.height);
        }
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
