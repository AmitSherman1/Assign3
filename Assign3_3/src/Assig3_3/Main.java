/*Amit Sherman 209284017
Stav Zysblatt 313434748 */
package Assig3_3;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Please Type How Many Salads To Prepare:");
        Scanner scan = new Scanner(System.in);
        final int numOfSaladsToPrepare = scan.nextInt();
        System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

        SlicerMachine slicerMachine = new SlicerMachine(numOfSaladsToPrepare);

        CucumbersThread cucumberThread = new CucumbersThread(slicerMachine, numOfSaladsToPrepare);
        TomatoesThread tomatoThread = new TomatoesThread(slicerMachine, numOfSaladsToPrepare);
        SlicerThread slicerThread = new SlicerThread(slicerMachine, numOfSaladsToPrepare);

        tomatoThread.start();
        cucumberThread.start();
        slicerThread.start();

        try {
            tomatoThread.join();
            cucumberThread.join();
            slicerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
        scan.close();
    }

}
