import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class GUI extends JFrame {
    private JLabel inputLabel = new JLabel("Input");
    private JLabel outputLabel = new JLabel("Output");
    private JTextField inputField = new JTextField(20);
    private JTextField outputField = new JTextField(20);
    private JPanel inputPanel = new JPanel();
    private JPanel btnPanel = new JPanel();
    private JButton copy = new JButton("Copy");
    private JButton clear = new JButton("Clear");
    private JButton print = new JButton("Print");
    private List<String> stringList = new ArrayList<>();
    public GUI()
    {
        setTitle("Title");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setResizable(false); setLocationRelativeTo(null);
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputLabel); inputPanel.add(inputField); inputPanel.add(outputLabel);
        inputPanel.add(outputField); outputField.setEnabled(false);
        copy.addActionListener(new CopyBtnActionListener()); print.addActionListener(new PrintBtnActionListener()); clear.addActionListener(new ClearBtnActionListener());
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(copy); btnPanel.add(print);btnPanel.add(clear);
        add(inputPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    class CopyBtnActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(inputField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The input field is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String input_text = inputField.getText();
                outputField.setText(input_text);
                stringList.add(input_text);
                JOptionPane.showMessageDialog(null, "Copied!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    class PrintBtnActionListener implements  ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(stringList.size() == 0)
            {
                JOptionPane.showMessageDialog(null,"The list is empty!","Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String msg = "List:\n";
                Iterator<String> iterator = stringList.iterator();
                while (iterator.hasNext()) {
                    msg += iterator.next() + "\n";
                }
                JOptionPane.showMessageDialog(null, msg, "List", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    class ClearBtnActionListener implements  ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText(null); outputField.setText(null);
            JOptionPane.showMessageDialog(null, "Cleared!", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
