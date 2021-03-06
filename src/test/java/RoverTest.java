import MarsRover.Rover;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    private Rover rover;
    @Before
    public void setUp() throws Exception {
        rover = new Rover();
    }

   public static Object[] testValuesRight(){
        return new Object[]{

                new String[]{"R","0,0,E"},
                new String[]{"RR", "0,0,S"},
                new String[]{"RRR", "0,0,W"},
                new String[]{"RRRR", "0,0,N"},
        };
    }
    @Test
    @Parameters(method = "testValuesRight")
    public void ifTheRoverRotateToTheRight(String commands, String direction){
        assertThat(rover.execute(commands), is(direction));
    }

    public static Object[] testValuesLeft(){
        return new Object[]{

                new String[]{"L","0,0,W"},
                new String[]{"LL", "0,0,S"},
                new String[]{"LLL", "0,0,E"},
                new String[]{"LLLL", "0,0,N"},
        };
    }
    @Test
    @Parameters(method = "testValuesLeft")
    public void ifTheRoverRotateToTheLeft(String commands, String direction){
        assertThat(rover.execute(commands), is(direction));
    }


    public static Object[] testValuesIfTheRoverMovesUp(){
        return new Object[]{

                new String[]{"M","0,1,N"},
                new String[]{"MMM", "0,3,N"},
        };
    }
    @Test
    @Parameters(method = "testValuesIfTheRoverMovesUp")
    public void theRoverShouldMoveUp(String commands, String direction){
        assertThat(rover.execute(commands), is(direction));
    }

    public static Object[] testValuesIfTheRoverMovesToTheRight(){
        return new Object[]{

                new String[]{"MMRMMRMRRM","5,1,E"},
                new String[]{"RMRR","3,2,N"},
                new String[]{"RMRRMR","3,3,E"},
                new String[]{"RMMRRMRMR","4,2,S"},
        };
    }
    @Test
    @Parameters(method = "testValuesIfTheRoverMovesToTheRight")
    public void ifTheRoverMovesRight(String commands, String direction){
        rover.setPosition(3,3, "E");
        assertThat(rover.execute(commands), is(direction));
    }

    public static Object[] testValuesIfTheRoverMovesToTheLeft(){
        return new Object[]{

                new String[]{"LMLMLMLMM","1,3,N"},

        };
    }
    @Test
    @Parameters(method = "testValuesIfTheRoverMovesToTheLeft")
    public void ifTheRoverMovesLeft(String commands, String direction){
        rover.setPosition(1,2, "N");
        assertThat(rover.execute(commands), is(direction));
    }

}
