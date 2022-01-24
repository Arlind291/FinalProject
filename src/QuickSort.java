import java.util.*;

public class QuickSort {
    public void runQuickSort(ArrayList<Integer> nums, Graph graph, GUI GUI) throws InterruptedException {
        quickSort(nums, graph,0, nums.size() - 1);
        GUI.needRefresh = true;
    }

    public int partition(ArrayList<Integer> subArray, Graph graph, int low, int high) throws InterruptedException {
        int i = low;
        int pivot = subArray.get(high);

        for (int j = low; j < high; j++) {
            if (subArray.get(j) < pivot) {
                Collections.swap(subArray, i, j);

                graph.updateArray(subArray);
                graph.paintImmediately(0,30,870,532);
                Thread.sleep(50);

                i++;
            }
        }
        Collections.swap(subArray, i, high);

        graph.updateArray(subArray);
        graph.paintImmediately(0,30,870,532);
        Thread.sleep(50);

        return i;
    }

    public void quickSort(ArrayList<Integer> array, Graph graph, int low, int high) throws InterruptedException {
        if (low < high) {
            int div = partition(array, graph, low, high);

            quickSort(array, graph, low,div - 1);
            quickSort(array, graph, div + 1, high);
        }
    }

}