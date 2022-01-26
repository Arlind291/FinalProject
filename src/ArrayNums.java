import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.*;

public class ArrayNums implements ActionListener  {
    JFormattedTextField input = new JFormattedTextField();
    JButton enter = new JButton("Enter");

    ArrayNums() {

        input.setBounds(670, 70, 140, 30);

        enter.setBounds(815, 70, 140, 30);
        enter.addActionListener(this);
        enter.setFocusable(false);
    }

    String test;
    int ii = Integer.valueOf(test);
    static int test2;

    public static String ret(int test2) {

    }

    public ArrayList<Integer> createArray() {
        ArrayList<Integer> nums = new ArrayList<>();


        for (int i = 1; i < ii; i++) {
            nums.add(8 * ii);
        }
        Collections.shuffle(nums);
        System.out.println(nums);

        return nums;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enter) {
            test = input.getText();
            System.out.println(test);
        }
    }
}
