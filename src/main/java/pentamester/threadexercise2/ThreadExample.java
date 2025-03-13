/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pentamester.threadexercise2;

/**
 *
 * @author shwak
 */
public class ThreadExample {

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            String threadName = "MioThread-" + (i + 1);
            int priority = Thread.NORM_PRIORITY;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread currentThread = Thread.currentThread();
                    synchronized (System.out) {
                        System.out.println("--- Informazioni di " + currentThread.getName() + " ---");
                        System.out.println("Nome: " + currentThread.getName());
                        System.out.println("ID: " + currentThread.getId());
                        System.out.println("Priorità: " + currentThread.getPriority());
                        System.out.println("È vivo? " + currentThread.isAlive());
                        System.out.println("Info completa: " + currentThread.toString());
                        System.out.println("Sto dormendo per 5 secondi...");
                    }

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(currentThread.getName() + " è stato interrotto durante il sonno.");
                    }

                    synchronized (System.out) {
                        System.out.println(currentThread.getName() + " ha terminato.\n");
                    }
                }
            }, threadName);

            threads[i].setPriority(priority);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(t.getName() + " è stato interrotto durante il join.");
            }
        }

        System.out.println("Main terminato!");
    }
}
