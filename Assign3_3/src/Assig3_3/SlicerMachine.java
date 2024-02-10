/*Amit Sherman 209284017
Stav Zysblatt 313434748 */
package Assig3_3;
public class SlicerMachine {

    int numOfCucumbers = 0;
    int numOfTomatoes = 0;
    int numOfPreparedSalads = 0;
    private final int saladsToPrepare;

    final int cucumbersNeededForOneSalad = 3;
    final int tomatoesNeededForOneSalad = 2;

    public SlicerMachine(int saladsToPrepare) {
        this.saladsToPrepare = saladsToPrepare;
    }

    // add one cucumber into the slicer chamber
    synchronized void addOneCucumber() {
        while (numOfCucumbers >= cucumbersNeededForOneSalad) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (getNumOfPreparedSalads() < saladsToPrepare) {
            System.out.println("Adding one cucumber to the machine");
            numOfCucumbers++;
            notifyAll();
        }
    }

    // add one tomato into the slicer chamber
    synchronized void addOneTomato() {
        while (numOfTomatoes >= tomatoesNeededForOneSalad) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (getNumOfPreparedSalads() < saladsToPrepare) {
            System.out.println("Adding one tomato to the machine");
            numOfTomatoes++;
            notifyAll();
        }
    }

    synchronized void sliceVegetables() {
        while (numOfCucumbers < cucumbersNeededForOneSalad || numOfTomatoes < tomatoesNeededForOneSalad) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        makeNewSalad();
        notifyAll();

    }

    private void makeNewSalad() {

        numOfPreparedSalads++;
        // update stock
        numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
        numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
        System.out.println("== Salad prepared ==");

        if (getNumOfPreparedSalads() >= saladsToPrepare) {
            return;
        }

        System.out.println("== preparing one more salad ==");
    }


    synchronized int getNumOfPreparedSalads() {
        return numOfPreparedSalads;
    }

}
