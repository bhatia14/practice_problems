package practice;

import java.util.HashMap;

public class MarsRover {
    public static void main(String[] args) {
        String gridSize = "5 5";
        //String startingPosition = "1 2 N";
        //String move = "LMLMLMLMM";

        String startingPosition = "3 3 E";
        String move = "MMRMMRMRRM";
        HashMap h = new HashMap();
        String[] x = (String[]) h.keySet().toArray();

        String[] moves =move.split("");

        Grid grid = new Grid(gridSize);
        Position position = new Position(startingPosition);

        for (String m: moves) {
            rover(m, position, grid);
        }
        System.out.println("X: "+position.getX()+" Y:" +position.getY()+" "+ position.getPosition());
    }

    private static void rover(String nextMove, Position position, Grid grid){
        if("M".equalsIgnoreCase(nextMove)) {
            move(position, grid);
        }
        else if("L".equalsIgnoreCase(nextMove)) {
            updateLeftPosition(position);
        }
        else if("R".equalsIgnoreCase(nextMove)) {
            updateRightPosition(position);
        }
    }

    private static void updateLeftPosition(Position position) {
        switch (position.getPosition()) {
            case "N":
                position.setPosition("W");
                break;
            case "S":
                position.setPosition("E");
                break;
            case "E":
                position.setPosition("N");
                break;
            case "W":
                position.setPosition("S");
                break;
        }
    }

    private static void updateRightPosition(Position position) {
        switch (position.getPosition()) {
            case "N":
                position.setPosition("E");
                break;
            case "S":
                position.setPosition("W");
                break;
            case "E":
                position.setPosition("S");
                break;
            case "W":
                position.setPosition("N");
                break;
        }
    }

    private static void move(Position position, Grid grid) {
        if ("E".equalsIgnoreCase(position.getPosition())){
            int x = position.getX();
            Position p = new Position(++x, position.getY(), position.getPosition());
            if(isValidMove(p, grid)) {
                position.setX(x);
            }
        }
        else if ("W".equalsIgnoreCase(position.getPosition())){
            int x = position.getX();
            Position p = new Position(--x, position.getY(), position.getPosition());
            if(isValidMove(p, grid)) {
                position.setX(x);
            }
        }
        else if ("N".equalsIgnoreCase(position.getPosition())){
            int y = position.getY();
            Position p = new Position(position.getX(), ++y, position.getPosition());
            if(isValidMove(p, grid)) {
                position.setY(y);
            }
        }
        else if ("S".equalsIgnoreCase(position.getPosition())){
            int y = position.getY();
            Position p = new Position(position.getX(), --y, position.getPosition());
            if(isValidMove(p, grid)) {
                position.setY(y);
            }
        }
    }

    private static boolean isValidMove(Position p, Grid grid){
        if(p.getX() >= 0 && p.getX() <= grid.getX()
        && p.getY() >= 0 && p.getY() <= grid.getY()){
            return true;
        }
        return false;
    }

    private static class Position {
        private int x;
        private int y;
        private String position;

        public Position(int x, int y, String position) {
            this.x = x;
            this.y = y;
            this.position = position;
        }

        public Position(String startingPosition) {
            String[] strings = startingPosition.split(" ");
            this.x = Integer.parseInt(strings[0]);
            this.y = Integer.parseInt(strings[1]);
            this.position = strings[2];
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }


    private static class Grid {

        private int x;
        private int y;

        public Grid(String gridSize){
            String[] strings = gridSize.split(" ");
            this.x = Integer.parseInt(strings[0]);
            this.y = Integer.parseInt(strings[1]);
        }
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }


    }
}
