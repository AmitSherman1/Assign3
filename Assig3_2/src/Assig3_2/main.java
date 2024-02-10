/*Amit Sherman 209284017
Stav Zysblatt 313434748 */
package Assig3_2;
public class main {
    public static void main(String[] args){
        GamePlay game = new GamePlay();
        Gamer p1 = new Gamer(game,Thread.currentThread());
        Gamer p2 = new Gamer(game,Thread.currentThread());
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();
        Assig3_2.Judge.JudgeGamePlay(game);
        if(p1.getScore() > p2.getScore())
            System.out.println("player 1 wins");
        else if(p1.getScore() < p2.getScore())
            System.out.println("player 2 wins");
        else
            System.out.println("tie");
    }
}