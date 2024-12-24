package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Oneal extends Enemy {
    protected int direction = (int) (Math.random() * 4);

    public Oneal() {
        super();
        score = 200;
        loadImage("oneal.png");
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public Oneal(int x, int y) {
        super(x, y);
        score = 200;
        loadImage("oneal.png");
        speed = 0.025;
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void move() {
        switch (direction) {
            case 0:
                if (imageView.getY() > 0) {
                    imageView.setY(imageView.getY() - speed * Main.SCALE);
                }
                break;
            case 1:
                if (imageView.getY() + imageView.getFitHeight() < Main.SCREEN_HEIGHT) {
                    imageView.setY(imageView.getY() + speed * Main.SCALE);
                }
                break;
            case 2:
                if (imageView.getX() > 0) {
                    imageView.setX(imageView.getX() - speed * Main.SCALE);
                }
                break;
            case 3:
                if (imageView.getX() + imageView.getFitWidth() < Main.SCREEN_WIDTH) {
                    imageView.setX(imageView.getX() + speed * Main.SCALE);
                }
                break;
        }
    }

    private boolean checkCollision() {
        for (Wall wall : Main.walls) {
            if (CollisionCheck.isCollide(this, wall)) {
                return true;
            }
        }
        for (Brick brick : Main.bricks) {
            if (CollisionCheck.isCollide(this, brick)) {
                return true;
            }
        }
        for (Enemy otherEnemy : Main.enemies) {
            if (otherEnemy != this && CollisionCheck.isCollide(this, otherEnemy)) {
                return true;
            }
        }
        for (Bomb bomb : Main.bombList) {
            if (CollisionCheck.isCollide(this, bomb)) {
                return true;
            }
        }
        return false;
    }

//    AnimationTimer balloomMove = new AnimationTimer() {
//        @Override
//        public void handle(long now) {
//            int x = getX();
//            int y = getY();
//            move();
//            if (checkCollision()) {
//                setX(x);
//                setY(y);
//                direction = ((int) (Math.random() * 100) + 1) % 4;
//            }
//            update();
//        }
//    };

    public void stepMove() {
        String directionString = "";
        switch (direction) {
            case 0: case 3:
                directionString = "right";
                break;
            case 1: case 2:
                directionString = "left";
        }
        loadImage("oneal_" + directionString + ((int) step / 5 + 1) + ".png");
        step++;
        update();
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.035), event -> {
        int x = getX();
        int y = getY();
        if (getX() == Main.player.getX()) {
            if (getY() >= Main.player.getY()) {
                direction = 0;
            } else {
                direction = 1;
            }
        } else if (getY() == Main.player.getY()) {
            if (getX() >= Main.player.getX()) {
                direction = 2;
            } else {
                direction = 3;
            }
        }
        move();
        stepMove();
        if (step == 15) {
            step = 0;
        }
        if (checkCollision()) {
            setX(x);
            setY(y);
            if (Main.player.isRendered() && !Main.player.isDead()) {
                if (getX() == Main.player.getX()) {
                    if (getY() >= Main.player.getY()) {
                        direction = 0;
                    } else {
                        direction = 1;
                    }
                } else if (getY() == Main.player.getY()) {
                    if (getX() >= Main.player.getX()) {
                        direction = 2;
                    } else {
                        direction = 3;
                    }
                } else {
                    direction = (int) (Math.random() * 4);
                }
            }
        }
        update();
    }));

    public void stepDead() {
        loadImage("oneal_dead" + ((int) step / 25) + ".png");
        step++;
        update();
    }

    AnimationTimer dead = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (step < 75) {
                stepDead();
            }
            if (step == 75) {
                remove();
                Main.enemies.remove(this);
                dead.stop();
            }
        }
    };

    @Override
    public void dead() {
        step = 0;
        timeline.stop();
        dead.start();
    }

    public void stopAnimation() {
        timeline.stop();
    }

    public void startAnimation() {
        timeline.play();
    }

}