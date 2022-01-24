import javax.swing.*;
import java.util.*;

public class SelectionSort extends JPanel {

    public void executeSelectionSort(ArrayList<Integer> nums, Graph graph, GUI GUI) throws InterruptedException {
        int id = 0;

        while (id < nums.size() - 1) {
            int lowest = nums.get(id);
            int lowest_idx = id;

            for (int i = id + 1; i < nums.size(); i++) {
                if (nums.get(i) < lowest) {
                    lowest = nums.get(i);
                    lowest_idx = i;
                }
            }
            Collections.swap(nums, id, lowest_idx);
            id++;

            Thread.sleep(100);
            graph.removeAll();
            graph.updateArray(nums);
            graph.revalidate();
            graph.paintImmediately(0,30,870,532);;
        }
        GUI.needRefresh = true;
    }
}
