import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;

/**
 *
 * */
public class Graph extends JPanel {
    ArrayList<Integer> nums;

    public Graph(ArrayList<Integer> array) {
        nums = array;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < nums.size(); i++) {
            g.setColor(new Color(155,17,30));
            g.fillRect(+ 16 * 1 * (i) + 1 * (i), 660 - nums.get(i), 15, nums.get(i));
        }
    }

    public void updateArray(ArrayList<Integer> array) {
        nums = array;
    }
}
