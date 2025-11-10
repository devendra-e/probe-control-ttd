package com.example.probe_control_tdd.controller;


import com.example.probe_control_tdd.model.Probe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    private final ProbeService service;

    public ProbeController(ProbeService service) {
        this.service = service;
    }

    @PostMapping("/command")
    public ResponseEntity<Probe> sendCommands(@RequestBody CommandRequest request) {
        Probe result = service.execute(request);
        return ResponseEntity.ok(result);
    }
}