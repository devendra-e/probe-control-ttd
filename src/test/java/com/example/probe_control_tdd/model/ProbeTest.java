package com.example.probe_control_tdd.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProbeTest {

    @Test
    void moveForwardFromNorthIncrementsY() {
        Probe p = new Probe(2,2,Direction.NORTH);
        p.moveForward();
        assertEquals(3, p.getY());
        assertEquals(2, p.getX());
    }

    @Test
    void moveBackwardFromNorthDecrementsY() {
        Probe p = new Probe(2,2,Direction.NORTH);
        p.moveBackward();
        assertEquals(1, p.getY());
    }

    @Test
    void turnLeftFromNorthBecomesWest() {
        Probe p = new Probe(0,0,Direction.NORTH);
        p.turnLeft();
        assertEquals(Direction.WEST, p.getDirection());
    }

    @Test
    void turnRightFromNorthBecomesEast() {
        Probe p = new Probe(0,0,Direction.NORTH);
        p.turnRight();
        assertEquals(Direction.EAST, p.getDirection());
    }

    @Test
    void visitedCoordinatesAreTracked() {
        Probe p = new Probe(0,0,Direction.NORTH);
        p.moveForward();
        p.turnRight();
        p.moveForward();
        assertTrue(p.getVisited().contains(new Probe.Point(0,1)));
        assertTrue(p.getVisited().contains(new Probe.Point(1,1)));
    }
}

