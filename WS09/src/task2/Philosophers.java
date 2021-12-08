package task2;

public class Philosophers implements Runnable {
    int id;
    Chopstick chop;

    Philosophers(int id, Chopstick chop) {
        this.id = id;
        this.chop = chop;
    }

    void think() {
        System.out.println("Philosopher number " + id + " is thinking");
    }

    void eat() {
        System.out.println("Philosopher number " + id + " is eating");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        think();
        try {
            chop.take(id);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        eat();
        chop.drop(id);
    }
}