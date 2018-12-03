package ru.atom.geometry;

public class Bar implements Collider{
    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        this.firstCornerX = firstCornerX;
        this.firstCornerY = firstCornerY;
        this.secondCornerX = secondCornerX;
        this.secondCornerY = secondCornerY;
    }

    public int getFirstCornerX() {
        return firstCornerX;
    }
    public void setFirstCornerX(int firstCornerX) {
        this.firstCornerX = firstCornerX;
    }
    public int getFirstCornerY() {
        return firstCornerY;
    }
    public void setFirstCornerY(int firstCornerY) {
        this.firstCornerY = firstCornerY;
    }
    public int getSecondCornerX() {
        return secondCornerX;
    }
    public void setSecondCornerX(int secondCornerX) {
        this.secondCornerX = secondCornerX;
    }
    public int getSecondCornerY() {
        return secondCornerY;
    }
    public void setSecondCornerY(int secondCornerY) {
        this.secondCornerY = secondCornerY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        if (Math.max(firstCornerX,secondCornerX) == Math.max(bar.firstCornerX,bar.secondCornerX) &
                Math.min(firstCornerX,secondCornerX) == Math.min(bar.firstCornerX,bar.secondCornerX) &
                Math.max(firstCornerY,secondCornerY) == Math.max(bar.firstCornerY,bar.secondCornerY) &
                Math.min(firstCornerY,secondCornerY) == Math.min(bar.firstCornerY,bar.secondCornerY)) {
            return true;
        }
        if (firstCornerX != bar.firstCornerX) return false;
        if (firstCornerY != bar.firstCornerY) return false;
        if (secondCornerX != bar.secondCornerX) return false;
        return secondCornerY == bar.secondCornerY;
    }

    @Override
    public int hashCode() {
        int result = firstCornerX;
        result = 31 * result + firstCornerY;
        result = 31 * result + secondCornerX;
        result = 31 * result + secondCornerY;
        return result;
    }

    @Override
    public boolean isColliding(Collider other) {
        boolean result = false;
        if (other instanceof Point) {
            Point point = (Point) other;
            if (point.getX() >= firstCornerX & point.getX() <= secondCornerX &
                    point.getY() >= firstCornerY & point.getY() <= secondCornerY) {
                result = true;
            }
        }
        if (other instanceof Bar) {
            Bar bar = (Bar) other;
            //(max_x1 > min_x2) и (max_x2 > min_x1) и (max_y1 > min_y2) и (max_y2 > min_y1)
            if (secondCornerX >= bar.firstCornerX & bar.secondCornerX >= firstCornerX &
                    secondCornerY >= bar.firstCornerY & bar.secondCornerY >= firstCornerY) {
                result = true;
            }
        }
        return result;
    }
}
