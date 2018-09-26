package treeGrow;

public class Land {

    // to do
    // sun exposureGrid data here
    float[][] exposureGrid;
    float[][] shadeGrid;

    static float shadefraction = 0.1f; // only this fraction of light is transmitted by a tree

    Land(int dx, int dy) {
        // to do
        exposureGrid = new float[dx][dy];
        shadeGrid = new float[dx][dy];
    }

    int getDimX() {
        return exposureGrid.length;
    }

    int getDimY() {
        return  exposureGrid[0].length;
    }

    // Reset the shaded landscape to the same as the initial sun exposed landscape
    // Needs to be done after each growth pass of the simulator
    void resetShade() {
        shadeGrid = exposureGrid;
    }

    float getFull(int x, int y) {
        return exposureGrid[x][y];
    }

    void setFull(int x, int y, float val) {
        exposureGrid[x][y] = val;
    }

    float getShade(int x, int y) {
        return shadeGrid[x][y];
    }

    void setShade(int x, int y, float val) {
        shadeGrid[x][y] = val;
    }

    // reduce the
    void shadow(Tree tree) {
        // to do
    }
}