
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            numPoints = numPoints + 1;
            currPt = prevPt;
        }
        return numPoints;
        
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double allSideSum = getPerimeter(s);
        int allNumPoints = getNumPoints(s);
        //typecast now
        double allNumP = allNumPoints;
        //Formula for Avg length
        double avgSide = allSideSum/allNumP ;
        return avgSide;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double maxLengthOfSide = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if (currDist > maxLengthOfSide){
            maxLengthOfSide = currDist;
            }
            
        }
        return maxLengthOfSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double LargestX = 0.0;
        for (Point currPt : s.getPoints()){
        double xCoord = currPt.getX();
        if (xCoord > LargestX){
        LargestX = xCoord;
        }
        
        }
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr =  new DirectoryResource();
        double largestPerim = 0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            
            if (perimeter > largestPerim){
                largestPerim = perimeter;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;   // replace this code
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0;
        for (File f : dr.selectedFiles()){ 
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s);
            if (perim > largestPerim){
                largestPerim = perim;
                temp = f;
            }
        }
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        //call getPerimeter method
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        //call getNumPoints method
         int numP = getNumPoints(s);
        System.out.println("number of points in shape s = " +numP);
        //call getAverageLength method
        double avgLength = getAverageLength(s);
        System.out.println("the average length of a side in your shape is: " + avgLength);
        //call getLargestSide method
        double maxSideL = getLargestSide(s);
        System.out.println("Largest Side Distance = " + maxSideL);
        //call getLargestX method
        double largestX = getLargestX(s);
        System.out.println("Largest X value is : " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter of Multiple Files is : " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter is : " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    // #this method first creates DirectoryResource, and than you are prompted to select files and than hold down shift key and select-
    // and select a second file. all files b/w first and second file will be highlighted. and than  code iterate over all selected files.
    // using for loop and selectedFiles method, printing out the filename for each file.
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //for largestPerimeterMultipleFiles
        PerimeterAssignmentRunner lpr = new PerimeterAssignmentRunner();
        lpr.testPerimeterMultipleFiles();
        //for File name with largest perimeter 
        PerimeterAssignmentRunner fwlpr = new PerimeterAssignmentRunner();
        fwlpr.testFileWithLargestPerimeter();
    }
}
