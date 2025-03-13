/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.threadexercise2;

/**
 *
 * @author shwak
 */
public class MioThread extends Thread {

    public MioThread(String name, int priority) {
        this.setName(name);
        this.setPriority(priority);
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        System.out.println("--- Informazioni di " + currentThread.getName() + " ---");
        System.out.println("Nome: " + currentThread.getName());
        System.out.println("ID: " + currentThread.getId());
        System.out.println("Priorità: " + currentThread.getPriority());
        System.out.println("È vivo? " + currentThread.isAlive());
        System.out.println("Info completa: " + currentThread.toString());

        System.out.println("Sto dormendo per 5 secondi...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(currentThread.getName() + " è stato interrotto.");
        }

        System.out.println(currentThread.getName() + " ha terminato.\n");
    }
}

