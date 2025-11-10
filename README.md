# probe-control-ttd

Spring Boot project: Submersible Probe Control REST API (TDD example)

## How to run

- Build: `mvn clean package`
- Run: `mvn spring-boot:run`
- Tests: `mvn test`

API:
POST /api/probe/command
Body:
{
  "startX": 2,
  "startY": 2,
  "direction": "NORTH",
  "commands": ["MOVE_FORWARD", "TURN_LEFT", "MOVE_FORWARD"]
}
