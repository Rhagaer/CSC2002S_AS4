package treeGrow.Controller;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import treeGrow.Land;
import treeGrow.Simulation;
import treeGrow.Tree;
import treeGrow.View.CommandListener;

import java.lang.reflect.Array;

public class Controller implements CommandListener{

    Land land;
    Tree[] trees;

    public Controller(Land land, Tree[] trees){
        this.land = land;
        this.trees = trees;
    }


    @Override
    public void onReset() {
        for (Tree tree : trees) {
            tree.reset();
        }
        Simulation.reset();
    }


    @Override
    public void onPause() {
        Simulation.pause();
    }

    @Override
    public void onPlay() {
        Simulation.play();
    }

    @Override
    public void onEnd() {
        System.exit(1);
    }
}
