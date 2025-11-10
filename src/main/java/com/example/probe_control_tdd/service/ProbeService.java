package com.example.probe_control_tdd.service;

import com.example.probe_control_tdd.model.CommandRequest;
import com.example.probe_control_tdd.model.Probe;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    public Probe execute(CommandRequest req) {
        Probe probe = new Probe(req.getStartX(), req.getStartY(), req.getDirection() == null ? Direction.NORTH : req.getDirection());
        if (req.getCommands() == null) return probe;
        for (String cmd : req.getCommands()) {
            switch (cmd) {
                case "MOVE_FORWARD" -> probe.moveForward();
                case "MOVE_BACKWARD" -> probe.moveBackward();
                case "TURN_LEFT" -> probe.turnLeft();
                case "TURN_RIGHT" -> probe.turnRight();
                default -> { /* ignore unknown commands */ }
            }
        }
        return probe;
    }
}