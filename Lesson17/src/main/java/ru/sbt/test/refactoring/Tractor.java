package ru.sbt.test.refactoring;

public class Tractor {

    int[] position = new int[] { 0, 0 };
    int[] field = new int[] { 5, 5 };
    private static final String COMMAND_F ="F";
    private static final String COMMAND_T = "T";
    Orientation orientation = Orientation.NORTH;


    public void move(String command) {
        if (command == COMMAND_F) {
            moveForwards();
        }
        if (command == COMMAND_T) {
            turnClockwise();
        }
    }


    public void moveForwards() {
        if (orientation == Orientation.NORTH) {
            position = updatePosition(position[0], position[1] + 1);
        }
        if (orientation == Orientation.EAST) {
            position = updatePosition(position[0] + 1, position[1]);
        }
        if (orientation == Orientation.SOUTH) {
            position = updatePosition(position[0], position[1] - 1);
        }
        if (orientation == Orientation.WEST) {
            position = updatePosition(position[0] - 1, position[1]);
        }
        if (position[0] > field[0] || position[1] > field[1]) {
            throw new TractorInDitchException();
        }
    }

    private int[] updatePosition(int firstPosition, int lastPosition) {
        int[] newPosition = new int[] { firstPosition, lastPosition };
        return newPosition;
    }

    public void turnClockwise() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        }
        if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        }
        if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        }
        if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
