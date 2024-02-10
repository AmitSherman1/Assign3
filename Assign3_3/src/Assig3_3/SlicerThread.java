/*Amit Sherman 209284017
Stav Zysblatt 313434748 */
package Assig3_3;
public class SlicerThread extends Thread {
    SlicerMachine slicerMachine;
    private final int saladsToPrepare;

    public SlicerThread(SlicerMachine slicerMachine, int saladsToPrepare) {
        this.saladsToPrepare = saladsToPrepare;
        this.slicerMachine = slicerMachine;
    }

    public void run() {
        while(slicerMachine.getNumOfPreparedSalads() < saladsToPrepare) {
            slicerMachine.sliceVegetables();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
