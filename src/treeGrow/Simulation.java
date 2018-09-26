package treeGrow;

import java.awt.*;

public class Simulation implements Runnable {

    Tree[] trees;
    Land land;

    public static int numGenerations;

    public Simulation(Land land, Tree[] trees) {
        this.trees = trees;
        this.land = land;
        numGenerations = 0;
    }

    @Override
    public void run() {

        while (true) {
            System.out.println("Sim Tree 2 Ext: " + trees[2].getExt() );
            numGenerations ++;
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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
        }

    }




}
