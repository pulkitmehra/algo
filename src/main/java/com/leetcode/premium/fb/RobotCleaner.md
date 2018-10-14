#Robot cleaner


> Given a robot cleaner in a room modeled as a grid.
  Each cell in the grid can be empty or blocked.
  The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
  When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
  Design an algorithm to clean the entire room using only the 4 given APIs shown below.


```
interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}


```
```
Input:
  room = [
    [1,1,1,1,1,0,1,1],
    [1,1,1,1,1,0,1,1],
    [1,0,1,1,1,1,1,1],
    [0,0,0,1,0,0,0,0],
    [1,1,1,1,1,1,1,1]
  ],
  row = 1,
  col = 3
```  
## Explanation:
  All grids in the room are marked by either 0 or 1.
  0 means the cell is blocked, while 1 means the cell is accessible.
  The robot initially starts at the position of row=1, col=3.
  From the top left corner, its position is one row below and three columns right.

Notes:

- The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
- The robot's initial position will always be in an accessible cell.
- The initial direction of the robot will be facing up.
- All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
- Assume all four edges of the grid are all surrounded by wall.

```class Solution {
    Set<String> cleaned;
    enum Directions {NORTH, SOUTH, EAST, WEST;};
    Directions direction;
    Robot robot;
    
    public void cleanRoom(Robot robot) {
        direction = Directions.NORTH;
        cleaned = new HashSet<>();
        this.robot = robot;
        visit(0, 0, robot);
    }
    
    private void visit(int x, int y, Robot robot) {
        if(cleaned.contains(x + "." + y)) {
            return;
        }
        robot.clean();
        cleaned.add(x + "." + y);
        
        //System.out.println("x = " + x + ", y = " + y);
        //System.out.println(cleaned);
        //System.out.println(direction);
        
        turnNorth();
        //moves takes you to the cell if if its visited
        if(robot.move()) {
            visit(x - 1, y, robot);
            //so you have to turn 360 back
            // everytime because you moved to visited cell
            turnSouth();
            robot.move();
        }
        turnSouth();
        if(robot.move()) {
            visit(x + 1, y, robot);
            //here robort must be at the visited cell
            //so turn opposite and move back
            //its backtracking 
            turnNorth();
            robot.move();
        }
        turnEast();
        if(robot.move()) {
            visit(x, y + 1, robot);
            turnWest();
            robot.move();
        }
        turnWest();
        if(robot.move()) {
            visit(x, y - 1, robot);
            turnEast();
            robot.move();
        }
    }
    
    private void turnNorth() {
        switch(direction) {
            case NORTH:
                break;
            case SOUTH:
                robot.turnLeft();
                robot.turnLeft();
                break;
            case EAST:
                robot.turnLeft();
                break;
            case WEST:
                robot.turnRight();
                break;
        }
        direction = Directions.NORTH;
    }
    
    private void turnSouth() {
        switch(direction) {
            case NORTH:
                robot.turnLeft();
                robot.turnLeft();
                break;
            case SOUTH:
                break;
            case EAST:
                robot.turnRight();
                break;
            case WEST:
                robot.turnLeft();
                break;
        }
        direction = Directions.SOUTH;
    }
    
    private void turnEast() {
        switch(direction) {
            case NORTH:
                robot.turnRight();
                break;
            case SOUTH:
                robot.turnLeft();
                break;
            case EAST:
                break;
            case WEST:
                robot.turnLeft();
                robot.turnLeft();
                break;
        }
        direction = Directions.EAST;
    }
    
    private void turnWest() {
        switch(direction) {
            case NORTH:
                robot.turnLeft();
                break;
            case SOUTH:
                robot.turnRight();
                break;
            case EAST:
                robot.turnLeft();
                robot.turnLeft();
                break;
            case WEST:
                break;
        }
        direction = Directions.WEST;
    }
}
```