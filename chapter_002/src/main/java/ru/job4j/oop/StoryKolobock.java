package ru.job4j.oop;

public class StoryKolobock {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        ball.run();
        hare.tryEat(ball);
        ball.song();

        ball.run();
        wolf.tryEat(ball);
        ball.song();

        ball.run();
        fox.tryEat(ball);
        ball.song();

        fox.tryEat(ball);
        ball.song();
    }
}
