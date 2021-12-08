package task2;

public class SolutionMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Chopstick chop = new Chopstick();
        Philosophers p1 = new Philosophers(0, chop);
        Philosophers p2 = new Philosophers(1, chop);
        Philosophers p3 = new Philosophers(2, chop);
        Philosophers p4 = new Philosophers(3, chop);
        Philosophers p5 = new Philosophers(4, chop);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(p5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}