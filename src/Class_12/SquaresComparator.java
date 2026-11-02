package Class_12;
import java.util.Comparator;

public class SquaresComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1 * o1, o2 * o2);
    }
}