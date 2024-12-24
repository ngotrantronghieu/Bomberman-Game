package com.example.demo;

public class CollisionCheck {

    private static boolean isCollideVertically(int topA, int bottomA, int topB, int bottomB) {
        return (bottomA > topB && bottomA < bottomB) || (bottomB > topA && bottomB < bottomA);
    }

    private static boolean isCollideHorizontally(int leftA, int rightA, int leftB, int rightB) {
        return (rightA > leftB && rightA < rightB) || (rightB > leftA && rightB < rightA);
    }

    public static boolean isDuplicate(Entity entityA, Entity entityB) {
        return entityA.getX() == entityB.getX() && entityB.getY() == entityA.getY();
    }

    public static boolean isCollide(Entity entityA, Entity entityB) {
        int leftA = entityA.getX();
        int rightA = entityA.getX() + entityA.getWidth();
        int topA = entityA.getY();
        int bottomA = entityA.getY() + entityA.getHeight();

        int leftB = entityB.getX();
        int rightB = entityB.getX() + entityB.getWidth();
        int topB = entityB.getY();
        int bottomB = entityB.getY() + entityB.getHeight();
        return (isCollideVertically(topA, bottomA, topB, bottomB)
                && isCollideHorizontally(leftA, rightA, leftB, rightB))
                || (isCollideVertically(topA, bottomA, topB, bottomB) && leftA == leftB)
                || isCollideHorizontally(leftA, rightA, leftB, rightB) && topA == topB
                || isDuplicate(entityA, entityB);
    }
}