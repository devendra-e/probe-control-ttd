package com.example.probe_control_tdd.model;

import java.util.List;

public class CommandRequest {
    private int startX;
    private int startY;
    private Direction direction;
    private List<String> commands;

    public CommandRequest() {}

    public int getStartX() { return startX; }
    public void setStartX(int startX) { this.startX = startX; }

    public int getStartY() { return startY; }
    public void setStartY(int startY) { this.startY = startY; }

    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

    public List<String> getCommands() { return commands; }
    public void setCommands(List<String> commands) { this.commands = commands; }
}
