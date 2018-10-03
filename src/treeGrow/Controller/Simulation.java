package treeGrow.Controller;

import treeGrow.Model.Land;
import treeGrow.Model.Tree;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Simulation implements Runnable {

    Tree[] trees;
    Land land;

    public static AtomicInteger numGenerations;
    public static AtomicBoolean paused;

    public Simulation(Land land, Tree[] trees) {
        this.trees = trees;
        this.land = land;
        numGenerations = new AtomicInteger(0);
        paused = new AtomicBoolean(false);
    }

    public static void reset() {
        numGenerations.set(0);
    }

    public static void pause() {
        paused.set(true);
    }

    public static void play() {
        paused.set(false);
        System.out.println("Status: " + paused);
    }

    @Override
    public void run() {

        while (true) {
            if (!paused.get()) {
                numGenerations.getAndIncrement();
                float minh = 18.0f;
                float maxh = 20.0f;
                land.resetShade();
                for (int layer = 0; layer <= 10; layer++) {
                    for (int t = 0; t < trees.length; t++) {
                        if (trees[t].inrange(minh, maxh)) {
                            trees[t].sungrow(land);
                        }
                    }
                    maxh = minh;  // next band of trees
                    minh -= 2.0f;
                }

            }else{
                System.out.println(paused);
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
