package MarsRover;

public class TurnLeft {
    public String turnLeft(String direction) {
        if (direction == "E") {
            return "N";
        } else if (direction == "N"){
            return "W";
        }if (direction == "W"){
            return "S";
        }else {
            return "E";
        }
    }

}
