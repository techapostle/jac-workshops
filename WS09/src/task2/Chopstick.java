package task2;

public class Chopstick {
    Boolean[] chops = { false, false, false, false, false };

    public synchronized void take(int i) throws InterruptedException {
        while (chops[i] || chops[(i + 1) % 5]) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e);
            }
        }
        chops[i] = true;
        chops[(i + 1) % 5] = true;
    }

    public synchronized void drop(int i) {
        chops[i] = false;
        chops[(i + 1) % 5] = false;
        notifyAll();
    }
}