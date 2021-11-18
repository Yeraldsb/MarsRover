package MarsRover;

public class TurnRight {

    public String turnRight(String direction) {
        if (direction == "N") {
            return "E";
        } else if (direction == "E") {
            return "S";
        }
        if (direction == "S") {
            return "W";
        } else {
            return "N";
        }
    }
}

