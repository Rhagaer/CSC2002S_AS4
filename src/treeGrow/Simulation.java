package treeGrow;

import java.awt.*;

public class Simulation implements Runnable {

    Tree[] trees;
    Land land;

    public static int numGenerations;
    public static boolean paused;

    public Simulation(Land land, Tree[] trees) {
        this.trees = trees;
        this.land = land;
        numGenerations = 0;
        paused = false;
    }

    public static void reset() {
        numGenerations = 0;
    }

    public static void pause() {
        paused = true;
    }

    public static void play() {
        paused = false;
        System.out.println("Status: " + paused);
    }

    @Override
    public void run() {

        while (true) {
            if (!paused) {
                System.out.println("Sim Tree 2 Ext: " + trees[2].getExt());
                numGenerations++;
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
