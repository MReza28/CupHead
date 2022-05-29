package model;

public class PositionVertex {
    private double fromLeft;
    private double fromTop;

    public PositionVertex (double fromLeft, double fromTop) {
        this.fromLeft = fromLeft;
        this.fromTop = fromTop;
    }

    //GETTERS
    public double getFromLeft() {
        return fromLeft;
    }

    public double getFromTop() {
        return fromTop;
    }
    ////GETTERS


    //SETTERS
    private void setFromLeft(double fromLeft) {
        this.fromLeft = fromLeft;
    }

    private void addFromLeft(double fromLeft) {
        this.fromLeft += fromLeft;
    }

    private void multiplyFromLeft (double multiplier) {
        this.fromLeft *= multiplier;
    }

    private void setFromTop(double fromTop) {
        this.fromTop = fromTop;
    }

    private void addFromTop (double fromTop) {
        this.fromTop += fromTop;
    }

    private void multiplyFromTop (double multiplier) {
        this.fromTop *= multiplier;
    }
    ////SETTERS

    //VERTEXES
    public void addPositionVertex (PositionVertex addingVertex) {
        this.addFromLeft(addingVertex.getFromLeft());
        this.addFromTop(addingVertex.getFromTop());
    }
    public void addPositionVertex (double fromLeft, double fromTop) {
        this.addFromLeft(fromLeft);
        this.addFromTop(fromTop);
    }

    public void multiplyPositionVertex (double multiplier) {
        this.multiplyFromLeft(multiplier);
        this.multiplyFromTop(multiplier);
    }
    ////VERTEXES

    //TODO adding angle and length of vertex and creating vertex by angle or length etc
}
