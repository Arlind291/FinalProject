import javax.swing.*;
import java.util.*;

/**
 *
 * */

public class InsertionSort extends JPanel {
    public void runInsertionSort(ArrayList<Integer> nums, Graph graph, GUI gui) throws InterruptedException {

        for (int static_i = 1; static_i < nums.size(); static_i++) {
            int moving_i = static_i;
            int compare_i = moving_i - 1;

            while (compare_i >= 0 && nums.get(compare_i) > nums.get(moving_i)) {
                // Swap and decrement
                Collections.swap(nums, compare_i, moving_i);
                moving_i = moving_i - 1;
                compare_i = compare_i - 1;

                Thread.sleep(25);
                graph.removeAll();
                graph.updateArray(nums);
                graph.revalidate();
                graph.paintImmediately(0,30,1500,632);
            }
        }
        gui.needRefresh = true;
    }
}
