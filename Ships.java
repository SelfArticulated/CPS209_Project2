import java.util.Random;
import java.util.ArrayList;


/**
 * This class creates ships that are layed out across the playing field
 */
public class Ships {
        
        //variables
        private int length;
        private ArrayList<Point> temp = new ArrayList<Point>();
        private static ArrayList<Point> points = new ArrayList<Point>();
        private static ArrayList<String> coords = new ArrayList<String>();

        public Ships(int length){
            this.length = length;
        }

        //getters
        public static ArrayList<String> getCoords(){ return coords; }
        public static ArrayList<Point> getPoints(){ return points; }

        //removes a point from the coordinate list
        public static void removePoint(String p){
            coords.remove(p);
        }

        //The layships method places the ships on specific coordinates
        public void LayShips() {
                
                boolean b = false;
                do {
                    Random r = new Random();
                    Point start = new Point(r.nextInt(10), r.nextInt(10) + 1); //chooses a starting coordinate "start"
                    if (points.toString().contains(start.toString()) == false){ //runs if starting coordinate is not already occupied by another ship
                        int direction = r.nextInt(4); //chooses a random cardinal direction
                        if ((direction == 0)||(direction == 2)){ //wil run "leftright" if direction is 0 or 2
                            direction--; //1 is subtracted to create either -1 or 1 
                            b = leftRight(start, direction);
                        } else {
                            int newdirection = direction - 2;
                            b = upDown(start, newdirection);
                        }
                        if (direction != 3){
                            direction++;
                        } else {
                            direction = 0;
                        }
                    } 
                } while (b == false);
                
                
                for (Point p : temp){
                    
                    coords.add(p.getCoord());
                    points.add(p);
                }
                System.out.println(points.toString());
                temp.clear();
                

        }
        /**
         * creates a list of coordinates that stream from the start coordinate either left or right for the length of the ship
         * if it hits a wall or another ship, it returns false
         * if true, the ship is added to the final list
         * if false, the ship is discarded and a new ship is chosen with a new direction.
         */
        public boolean leftRight(Point start, int direction){
            temp.add(start);
            for (int i = 1; i < this.length; i++){
                int s = start.getx() + direction;
                String str = String.valueOf(s) + ", " + String.valueOf(start.gety());
                if ((s > -1)&&(s < 10)&&(points.toString().contains(str) == false)){
                    start = new Point(s, start.gety());
                    temp.add(start);
                } else {
                    temp.clear();
                    return false;
                }
            }
            return true;
        }

        /**
         * a duplicate of the leftright function with one major difference
         * The ship is instead built vertically, extending up or down
         */
        public boolean upDown(Point start, int direction){
            temp.add(start);
            for (int i = 1; i < this.length; i++){
                int s = start.gety() + direction;
                String str = String.valueOf(start.getx()) + ", " + String.valueOf(s);
                if ((s > -1)&&(s < 10)&&(points.toString().contains(str) == false)){
                    start = new Point(start.getx(), s);
                    temp.add(start);
                } else {
                    temp.clear();
                    return false;
                }
            }
            return true;
        }
}

/**
 * the Point class in the same file
 * Each ship is made up of a series of points: a letter coordinate and a number coordinate

 */
class Point {

        private int x;
        private int y;
        private String coord;

        public Point (int x, int y){
            this.x = x;
            this.y = y;
            this.coord = Testbox.getLetters()[x] + String.valueOf(y);
        }
        public int getx(){ return this.x; }
        public int gety(){ return this.y; }
        public void setx(int newX){ this.x = newX; }
        public void sety(int newY){ this.y = newY; }
        public String getCoord(){ return this.coord; }
        @Override
        public String toString(){
            return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
        }
}
