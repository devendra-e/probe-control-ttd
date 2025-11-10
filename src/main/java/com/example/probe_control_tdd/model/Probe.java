package com.example.probe_control_tdd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Probe {
    private int x;
    private int y;
    private Direction direction;
    private final List<Point> visited = new ArrayList<>();

    public Probe() {}

    public Probe(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        visited.add(new Point(x,y));
    }

    public void moveForward() {
        switch(direction) {
            case NORTH -> y++;
            case SOUTH -> y--;
            case EAST  -> x++;
            case WEST  -> x--;
        }
        visited.add(new Point(x,y));
    }

    public void moveBackward() {
        switch(direction) {
            case NORTH -> y--;
            case SOUTH -> y++;
            case EAST  -> x--;
            case WEST  -> x++;
        }
        visited.add(new Point(x,y));
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    // getters and setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

    public List<Point> getVisited() { return visited; }

    @Override
    public String toString() {
        return "Probe{" + "x=" + x + ", y=" + y + ", direction=" + direction + '}';
    }

    public static class Point {
        private int x;
        private int y;
        public Point() {}
        public Point(int x,int y){this.x=x;this.y=y;}
        public int getX(){return x;}
        public void setX(int x){this.x=x;}
        public int getY(){return y;}
        public void setY(int y){this.y=y;}
        @Override public boolean equals(Object o){
            if(this==o) return true;
            if(o==null||getClass()!=o.getClass()) return false;
            Point p=(Point)o;
            return x==p.x && y==p.y;
        }
        @Override public int hashCode(){return Objects.hash(x,y);}
    }
}

