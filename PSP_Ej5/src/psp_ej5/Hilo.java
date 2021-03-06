/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej5;

/**
 *
 * @author oracle
 */
class Hilo extends Thread {
    //id del proceso
    int pid;
    //cuenta de hilos
    static int conta = 0;

    public Hilo(int pid) {
        //asignamos el id
        this.pid = pid;
        //preguntamos si es el primer hilo
        if (Hilo.conta == 0) {
            //le asignamos la minima prioridad
            this.setPriority(Thread.MIN_PRIORITY);
            //sumamos la cuenta para que el hilo hijo no entre en este if
            Hilo.conta++;
            //creamos el hilo hijo
            Hilo h2 = new Hilo(2);
            //le asignamos maxima prioridad
            h2.setPriority(Thread.MAX_PRIORITY);
        }
        //empezamos el hilo, aun asi con prioridades es posible que no se ejecute primero el segundo hilo
        this.start();
    }

    public void run() {

        System.out.println("Hola soy el Hilo " + pid);

    }
}
