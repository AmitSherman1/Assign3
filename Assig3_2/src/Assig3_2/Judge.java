/*Amit Sherman 209284017
Stav Zysblatt 313434748 */
package Assig3_2;
public class Judge {

    public static void JudgeGamePlay(GamePlay gamePlay) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000);
                gamePlay.makeCoinAvail(true);
                Thread.sleep(500);
                gamePlay.makeCoinAvail(false);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}

