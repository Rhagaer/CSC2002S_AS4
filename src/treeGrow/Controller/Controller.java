package treeGrow.Controller;

import treeGrow.Model.Land;
import treeGrow.Model.Tree;
import treeGrow.View.CommandListener;

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
