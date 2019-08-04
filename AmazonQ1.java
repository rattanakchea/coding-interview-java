import java.util.List;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonQ1 {

    public static void main(String str[]) {
        System.out.println("hello");
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations, int truckCapacity) {
        // for ( List<Integer> list : allLocations) {
        // System.out.println(findDistance(list.get(0), list.get(1)));
        // }

        // sort allLocation by distance
        Collections.sort(allLocations, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return Double.compare(findDistance(a), findDistance(b));
            }
        });

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < truckCapacity; i++) {
            result.add(allLocations.get(i));
        }
        return result;
    }

    double findDistance(List<Integer> list) {
        return Math.sqrt(list.get(0) * list.get(0) + list.get(1) * list.get(1));
    }
    // METHOD SIGNATURE ENDS
}