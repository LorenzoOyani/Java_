package org.example.threads;

/**
 * Multi-threading enables multiple tasks to be carried out concurrently
 * A thread is a flow of execution from beginning to end, of a task.
 * in Java each task is an instance of the  Runnable interface.Also called a runnable Object.
 * Create a task class that implement runnable
 * A task must implement runnable interface, and a task must be called from a thread.
 * when two tasks is accessing a common resource, it causes conflict and inflict what we call a Race condition -
 * in multiThreaded programs.
 * A class is said to be thread-safe, when it doesn't cause race-condition in presence of multiple threads
 *
 * Solve Ration class in page 545.
 * Static variables are known as class variables
 * Instance variables are called members or fields.
 * Instance members are associated with individual objects, whereas static method are associated with class itself
 *  Instance members require an instance of a class to be accessed, whereas static methods require the class
 *  Instance members contribute to the state of each individual objects. static members represent shared
 *  state across all instance of the class.
 */
public class Threading {

    void main() {
        Runnable pointA = new printChar('a', 1000);
        Runnable pointB = new printChar('b', 10);
        Runnable number1 = new printNum(50);

        Thread thread = new Thread(pointA);
        Thread thread2 = new Thread(pointB);
        Thread thread3 = new Thread(number1);

        thread.start();
        thread2.start();
        thread3.start();
    }
}



//class printNum implements Runnable {
//
//}
