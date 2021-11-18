package MarsRover;

public class Rover {

    TurnRight turnRight = new TurnRight();
    TurnLeft turnLeft = new TurnLeft();

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
                direction = turnRight.turnRight(direction);
            }
            if (c == 'L'){
                direction = turnLeft.turnLeft(direction);
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
    public void printPosition() {
        System.out.println(x  + " "  + y   + " " +  direction);
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
