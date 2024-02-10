/*Amit Sherman 209284017
Stav Zysblatt 313434748 */
package Assig3_3;
public class TomatoesThread extends Thread {

    private SlicerMachine slicerMachine;
    private final int saladsToPrepare;

    public TomatoesThread(SlicerMachine slicerMachine, int saladsToPrepare) {
        this.slicerMachine = slicerMachine;
        this.saladsToPrepare = saladsToPrepare;
    }

    public void run() {
        while (slicerMachine.getNumOfPreparedSalads() < saladsToPrepare) {
            slicerMachine.addOneTomato();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
