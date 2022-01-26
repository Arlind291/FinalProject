import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ServiceLoader;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame implements ActionListener /*ChangeListener*/ {
    //Combo Box
    JComboBox comboBox;

    //Labels
    JLabel label;
    JPanel UpPanel = new JPanel();

    String selected = "";

    //ImageIcon
    ImageIcon icon = new ImageIcon("src/logo/logo.png");

    //MenuBar
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem saveItem;

    //Class Objects
    ArrayNums newArray = new ArrayNums();
    ArrayList<Integer> array = newArray.createArray();
    BubbleSort bubble = new BubbleSort();
    SelectionSort selection = new SelectionSort();
    InsertionSort insertion = new InsertionSort();
    QuickSort quick = new QuickSort();
    Graph graph = new Graph(array);


    //JButtons
    JButton start;
    JButton refresh;
    JButton enter;

    // Elapsed time / Runtime
    JLabel elapsedTime;
    JLabel runtimeLabel;

    // Boolean value for refresh check
    boolean needRefresh = false;

    GUI() {
        // Frame Name / Icon / Size / Exit
        this.setTitle("Sorting Algorithms Visualizer");
        this.setSize(1000, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setIconImage(icon.getImage());

        //Menu Bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        saveItem = new JMenuItem("Save");

        // Title
        label = new JLabel("Sorting Algorithms Visualizer");
        label.setBounds(235, 0, 400, 60);
        label.setFont(new Font("Arial Rounded MT Bolt", Font.BOLD, 26));
        label.setForeground(Color.white);

        // Runtime label
        runtimeLabel = new JLabel("Runtime: ");
        runtimeLabel.setBounds(10, 10, 200, 30);
        runtimeLabel.setFont(new Font("Arial Rounded MT Bolt", Font.BOLD, 15));
        runtimeLabel.setForeground(Color.white);

        // elapsedTime label
        elapsedTime = new JLabel("Elapsed Time: ");
        elapsedTime.setBounds(10, 30, 300, 30);
        elapsedTime.setFont(new Font("Arial Rounded MT Bolt", Font.BOLD, 15));
        elapsedTime.setForeground(Color.WHITE);

        // Combo Box
        String[] algorithms = {"Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Merge Sort"};
        comboBox = new JComboBox(algorithms);
        comboBox.setBounds(330, 70, 155, 30);
        comboBox.addActionListener(this);

        // Start Button / Refresh Button
        start = new JButton("Start");
        start.setBounds(670, 30, 140, 30);
        start.setFocusable(false);
        start.addActionListener(this);

        refresh = new JButton("Refresh");
        refresh.setBounds(815, 30, 140, 30);
        refresh.setFocusable(false);
        refresh.addActionListener(this);

        // Align panels
        UpPanel.setBounds(0, 0, 870, 100);
        graph.setBounds(0, 105, 900, 500);

        // Background colours
        UpPanel.setBackground(Color.black);
        graph.setBackground(Color.black);

        // Add panels
        UpPanel.add(label);
        UpPanel.add(runtimeLabel);
        UpPanel.add(comboBox);
        UpPanel.add(start);
        UpPanel.add(refresh);
        UpPanel.add(elapsedTime);
        UpPanel.add(newArray.input);
        UpPanel.add(newArray.enter);
        UpPanel.setLayout(new BorderLayout());

        // Add MenuBar
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);

        this.setLayout(new BorderLayout());
        this.setJMenuBar(menuBar);
        this.add(graph);
        this.add(UpPanel);
        this.validate();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        long startTime;
        long endTime;
        double time;

        // Check status before pressing start button
        if (e.getSource() == start & comboBox.getSelectedItem() != "Select Algorithm" & !needRefresh) {
            //Bubble Sort
            if (selected.equals("Bubble")) {
                startTime = System.currentTimeMillis();
                System.out.println("Bubble Sort Selected");
                try {
                    bubble.runBubbleSort(array, graph, this);
                    System.out.println("Sorting finished");

                    //Elapsed time
                    endTime = System.currentTimeMillis();
                    time = (endTime - startTime) / 1000.0;
                    System.out.println("It took " + time + " seconds to sort");
                    elapsedTime.setText("Elapsed Time: " + time + "s");
                    JOptionPane.showMessageDialog(null, "Sorting finished!", "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);

                } catch (InterruptedException err) {
                    err.printStackTrace();
                }

                //Selection Sort
            } else if (selected == "Selection") {
                startTime = System.currentTimeMillis();
                System.out.println("Selection Sort Selected");
                try {
                    selection.executeSelectionSort(array, graph, this);
                    System.out.println("Sorting finished");
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }

                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished!", "Selection Sort", JOptionPane.INFORMATION_MESSAGE);

                //Insertion Sort
            } else if (selected == "Insertion") {
                startTime = System.currentTimeMillis();
                System.out.println("Insertion Sort Selected");
                try {
                    insertion.runInsertionSort(array, graph, this);
                    System.out.println("Sorting finished");
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }

                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished!", "Insertion Sort", JOptionPane.INFORMATION_MESSAGE);

                //Quick Sort
            } else if (selected == "Quick") {
                startTime = System.currentTimeMillis();
                System.out.println("Quick Sort Selected");
                try {
                    quick.runQuickSort(array, graph, this);
                    System.out.println("Sorting finished");
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }

                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished!", "Quick Sort", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //Refresh button status
        if (e.getSource() == refresh) {
            array = newArray.createArray();
            graph.updateArray(array);
            graph.repaint();
            needRefresh = false;
        }
        //Combobox
        if (e.getSource() == comboBox) {
            if (comboBox.getSelectedItem() == "Bubble Sort") {
                selected = "Bubble";
                runtimeLabel.setText("Runtime: O(N^2)");
            } else if (comboBox.getSelectedItem() == "Selection Sort") {
                selected = "Selection";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (comboBox.getSelectedItem() == "Insertion Sort") {
                selected = "Insertion";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (comboBox.getSelectedItem() == "Quick Sort") {
                selected = "Quick";
                runtimeLabel.setText("Runtime: Nlog(N)");
            }
        }
    }
}

