package net.jsenko.pv260.geometry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jakub Senko
 */
public class Path implements Iterable<Point> {

    private List<Point> path;


    public Path() {
        path = new ArrayList();
    }


    public void addCopy(Point p) {
        path.add(new Point(p.getX(), p.getY()));
    }

    public boolean collides(Point point) {
        return  path.contains(point);
    }

    @Override
    public Iterator<Point> iterator() {
        return path.iterator();
    }
}
