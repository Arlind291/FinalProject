import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * class GUI: all the functions of the GUI frame and design
 * @author Arlind, Xhuljo
 * */
class GUI extends JFrame implements ActionListener {

    //Labels
    JLabel label;
    JPanel UpPanel = new JPanel();

    //ImageIcon
    ImageIcon icon = new ImageIcon("src/logo/logo.png");

    //Combo Box
    JComboBox comboBox;

    //MenuBar
    JMenuBar menuBar;
    JMenuItem saveItem;

    //Class Objects
    ArrayNums newArray = new ArrayNums();
    ArrayList<Integer> array = newArray.createArray();
    BubbleSort bubble = new BubbleSort();
    BogoSort bogoSort = new BogoSort();
    QuickSort quickSort = new QuickSort();
    SelectionSort selection = new SelectionSort();
    InsertionSort insertion = new InsertionSort();
    Graph graph = new Graph(array);

    //JButtons
    JButton start;
    JButton refresh;

    //Elapsed time / Runtime label
    JLabel elapsedTime;
    JLabel runtimeLabel;

    // Boolean value for refresh check
    boolean needRefresh = false;

    /**
     * Constructor GUI to set up the UI frame
     * */
    protected GUI() {
        // Frame Name / Icon / Size / Exit
        this.setTitle("Sorting Algorithms Visualizer");
        this.setSize(1200, 830);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(icon.getImage());

        //Menu Bar
        menuBar = new JMenuBar();
        saveItem = new JMenuItem("Save");

        // Title
        label = new JLabel("Sorting Algorithms Visualizer");
        label.setBounds(255, 0, 400, 60);
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
        String[] algorithms = {"Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Bogo Sort", "Quick Sort"};
        comboBox = new JComboBox(algorithms);
        comboBox.setBounds(355, 70, 155, 30);
        comboBox.addActionListener(this);

        // Start Button / Refresh Button
        start = new JButton("Start");
        start.setBounds(770, 12, 140, 30);
        start.setFocusable(false);
        start.addActionListener(this);

        refresh = new JButton("Refresh");
        refresh.setBounds(915, 12, 140, 30);
        refresh.setFocusable(false);
        refresh.addActionListener(this);

        // Align panels
        UpPanel.setBounds(0, 0, 870, 100);
        graph.setBounds(0, 130, 1190, 660);

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

        this.setLayout(new BorderLayout());
        this.setJMenuBar(menuBar);
        this.add(graph);
        this.add(UpPanel);
        this.validate();
        this.setVisible(true);
    }

    /**
     * GUI action performed functions
     * */
    String selected = "";
    @Override
    public void actionPerformed(ActionEvent e) {

        //Combobox
        if (e.getSource() == comboBox) {
            if (comboBox.getSelectedItem() == "Bubble Sort") {
                selected = "Bubble";
                runtimeLabel.setText("Runtime: O(N²)");
            } else if (comboBox.getSelectedItem() == "Selection Sort") {
                selected = "Selection";
                runtimeLabel.setText("Runtime: O(N²)");

            } else if (comboBox.getSelectedItem() == "Insertion Sort") {
                selected = "Insertion";
                runtimeLabel.setText("Runtime: O(N²)");

            } else if (comboBox.getSelectedItem() == "Bogo Sort") {
                selected = "Bogo Sort";
                runtimeLabel.setText("Runtime: O(n!)");

            } else if (comboBox.getSelectedItem() == "Quick Sort") {
                selected = "Quick Sort";
                runtimeLabel.setText("Runtime: O(n logn) ");
            }
        }

        //Refresh button status
        if (e.getSource() == refresh) {
            array = newArray.createArray();
            graph.updateArray(array);
            graph.repaint();
            needRefresh = false;
        }

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
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished! \n It took: " + time + " seconds", "Bubble Sort", JOptionPane.INFORMATION_MESSAGE);

                //Selection Sort
            } else if (selected.equals("Selection")) {
                startTime = System.currentTimeMillis();
                System.out.println("Selection Sort Selected");
                try {
                    selection.runSelectionSort(array, graph, this);
                    System.out.println("Sorting finished");
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished! \n It took: " + time + " seconds", "Selection Sort", JOptionPane.INFORMATION_MESSAGE);

                //Insertion Sort
            } else if (selected.equals("Insertion")) {
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
                JOptionPane.showMessageDialog(null, "Sorting finished! \n It took: " + time + " seconds", "Insertion Sort", JOptionPane.INFORMATION_MESSAGE);

            } else if (selected.equals("Bogo Sort")) {
                startTime = System.currentTimeMillis();
                System.out.println("Bogo Sort Selected");
                try {
                    bogoSort.runBogoSort(array, graph, this);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished! \n It took: " + time + " seconds", "Bogo Sort", JOptionPane.INFORMATION_MESSAGE);

            } else if (selected.equals("Quick Sort")) {
                startTime = System.currentTimeMillis();
                System.out.println("Quick Sort Selected");
                try {
                    quickSort.runQuickSort(array, graph,this);
                    System.out.println("Sorting finished");
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
                //Elapsed time
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;
                System.out.println("It took " + time + " seconds to sort");
                elapsedTime.setText("Elapsed Time: " + time + "s");
                JOptionPane.showMessageDialog(null, "Sorting finished! \n It took: " + time + " seconds", "Quick Sort", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

