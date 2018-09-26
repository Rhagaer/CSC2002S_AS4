package treeGrow;

// Trees define a canopy which covers a square area of the landscape
public class Tree {

    private
    int xpos;    // x-coordinate of center of tree canopy
    int ypos;    // y-coorindate of center of tree canopy
    float ext;    // extent of canopy out in vertical and horizontal from center

    static float growfactor = 1000.0f; // divide average sun exposureGrid by this amount to get growth in extent

    public Tree(int x, int y, float e) {
        xpos = x;
        ypos = y;
        ext = e;
    }

    public void reset(){
        this.ext = 0.4f;
    }

    int getX() {
        return xpos;
    }

    int getY() {
        return ypos;
    }

    float getExt() {
        return ext;
    }

    void setExt(float e) {
        ext = e;
    }

    // return the average sunlight for the cells covered by the tree
    float sunexposure(Land land) {

        int xStart = Math.max(0, this.xpos - (int) Math.ceil(this.ext));
        int xEnd = Math.min(land.getDimX(), this.xpos + (int) Math.ceil(ext));
        int yStart = Math.max(0, this.ypos - (int) Math.ceil(this.ext));
        int yEnd = Math.min(land.getDimY(), this.ypos + (int) Math.ceil(ext));

        float sum = 0f;
        float numSqaures = 0f;

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                numSqaures++;
                float sunlight = land.getShade(x ,y);
                sum += sunlight;
//                land.setShade(x ,y, sunlight*Land.shadefraction);
            }
        }
        return sum / numSqaures;
    }

    // is the tree extent within the provided range [minr, maxr)
    boolean inrange(float minr, float maxr) {
        return (ext >= minr && ext < maxr);
    }

    // grow a tree according to its sun exposureGrid
    void sungrow(Land land) {
        ext += sunexposure(land) / growfactor;
    }
}