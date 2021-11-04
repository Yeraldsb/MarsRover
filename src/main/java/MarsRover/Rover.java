package MarsRover;

public class Rover {

    String direction = "N";
    char facing = 'N';
    int x = 0;
    int y = 0;

    public void setPosition(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String execute(String commands) {
        for (char c : commands.toCharArray()){   //manipulate individual characters in a string as list items
            if (c == 'R'){
                direction = turnRight();
            }
            if (c == 'L'){
                direction = turnLeft();
            }
            if (c == 'M'){
                move();
            }
        }
        return x + "," + y + "," + direction;
    }

    public void move() {
        if (direction == "N") {
            this.y++ ;
        } else if (direction == "E"){
            this.x++;
        }else if (direction == "S"){
            this.y--;
        }else if (direction == "W"){
            this.x--;
        }
    }

    public String turnRight() {
        if (direction == "N") {
            return "E";
        } else if (direction == "E"){
            return "S";
        }if (direction == "S"){
            return "W";
        }else {
            return "N";
        }
    }

    public String turnLeft() {
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
    public void printPosition() {
        String dir = direction;
        if (facing == 1) {
            dir = "N";
        } else if (facing == 2) {
            dir = "E";
        } else if (facing == 3) {
            dir = "S";
        } else if (facing == 4) {
            dir = "W";
        }
        System.out.println(x  + " "  + y   + " " +  dir);
    }

    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, "N");
        rover.execute("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N
        rover.setPosition(3, 3, "E");
        rover.execute("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E
    }
}
