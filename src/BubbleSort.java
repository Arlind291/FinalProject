import javax.swing.*;
import java.util.*;

/**
 *
 * */
public class BubbleSort extends JPanel {
    boolean swapped = true;

    public void runBubbleSort(ArrayList<Integer> nums, Graph graph, GUI gui) throws InterruptedException {
        // Start bubble sorting
        while (swapped) {
            swapped = false;
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) > nums.get(i+1)) {
                    Collections.swap(nums, i, i+1);
                    swapped = true;

                    Thread.sleep(10);
                    graph.removeAll();
                    graph.updateArray(nums);
                    graph.revalidate();
                    graph.paintImmediately(0,30,1500,632);
                }
            }
        }
        swapped = true;
        //gui.needRefresh = false;
    }
}
