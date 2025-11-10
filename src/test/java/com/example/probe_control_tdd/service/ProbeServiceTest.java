package com.example.probe_control_tdd.service;

import java.util.List;

public class ProbeServiceTest {
    @Test
    void serviceExecutesCommandsSequence() {
        ProbeService svc = new ProbeService();
        CommandRequest req = new CommandRequest();
        req.setStartX(1);
        req.setStartY(1);
        req.setDirection(Direction.NORTH);
        req.setCommands(List.of("MOVE_FORWARD","TURN_RIGHT","MOVE_FORWARD"));
        Probe res = svc.execute(req);
        assertEquals(2, res.getX());
        assertEquals(2, res.getY());
        assertEquals(Direction.EAST, res.getDirection());
    }

    @Test
    void unknownCommandsAreIgnored() {
        ProbeService svc = new ProbeService();
        CommandRequest req = new CommandRequest();
        req.setStartX(0);
        req.setStartY(0);
        req.setDirection(Direction.NORTH);
        req.setCommands(List.of("FLY","MOVE_FORWARD"));
        Probe res = svc.execute(req);
        assertEquals(0, res.getX());
        assertEquals(1, res.getY());
    }
}
