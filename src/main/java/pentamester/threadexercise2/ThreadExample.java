/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.threadexercise2;

/**
 *
 * @author shwak
 */
public class ThreadExample {

    public static void main(String[] args) {

        MioThread[] threads = new MioThread[5];

        for (int i = 0; i < 5; i++) {
            String threadName = "MioThread-" + (i + 1);
            int priority = Thread.NORM_PRIORITY;
            threads[i] = new MioThread(threadName, priority);
            threads[i].start();
        }

        for (MioThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(t.getName() + " è stato interrotto durante il join.");
            }
        }

        System.out.println("Main terminato!");
    }
}


