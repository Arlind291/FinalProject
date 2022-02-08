import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

/**
 *
 * */
public class ArrayNums implements ActionListener  {
    JFormattedTextField input = new JFormattedTextField();
    JButton enter = new JButton("Enter");
    JOptionPane pane = new JOptionPane();

    ArrayNums() {
        input.setBounds(770, 50, 140, 30);
        input.setText("Enter a number");

        enter.setBounds(915, 50, 140, 30);
        enter.addActionListener(this);
        enter.setFocusable(false);
    }

    String test = "0";

    public ArrayList<Integer> createArray() {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i < Integer.parseInt(test); i++) {
                nums.add(9 * i);
        }
        Collections.shuffle(nums);
        System.out.println(nums);

        return nums;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enter) {
            test = input.getText();
            if(Integer.parseInt(test) > 70) {
                pane.showMessageDialog(null, "Enter a smaller number!", "Selection Sort", JOptionPane.WARNING_MESSAGE);
            }
            else if(Integer.parseInt(test) < 0) {
                pane.showMessageDialog(null, "Enter a larger number!", "Selection Sort", JOptionPane.WARNING_MESSAGE);
            }
            else {
                System.out.println(test);
            }
        }
    }
}
