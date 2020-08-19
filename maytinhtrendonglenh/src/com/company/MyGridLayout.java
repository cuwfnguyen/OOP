package com.company;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyGridLayout extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private GridLayout gridLayout;
    private JLabel lbHGap;
    private JLabel lbVGap;
    final int dram = 3;

    public MyGridLayout() {
        createJFrame();
    }

    private void createJFrame() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        // add content to JFrame
        mainPanel = createMainPanel();
        add(mainPanel);
        // display
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        // create JPanel with GridLayout
        gridLayout = new GridLayout(3, 2, 5, 5);
        JPanel panel = new JPanel(gridLayout);
        // add four JButton to panel
        panel.add(createJButton("+ vGap"));
        panel.add(createJButton("- vGap"));
        panel.add(createJButton("+ hGap"));
        panel.add(createJButton("- hGap"));
        // create and add vGap and hGap JLabel to panel
        lbVGap = createJLabel("vGap = 5");
        lbHGap = createJLabel("hGap = 5");
        panel.add(lbVGap);
        panel.add(lbHGap);
        return panel;
    }

    // create JButton
    private JButton createJButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }

    // create JLabel
    private JLabel createJLabel(String title) {
        JLabel lb = new JLabel(title);
        lb.setHorizontalAlignment(JLabel.CENTER);
        return lb;
    }

    // change vGap and hGap
    private void changeGap(int vGap, int hGap) {
        if (vGap >= 0 && hGap >= 0) {
            gridLayout.setVgap(vGap);
            gridLayout.setHgap(hGap);
            lbVGap.setText("vGap = " + vGap);
            lbHGap.setText("hGap = " + hGap);
            gridLayout.layoutContainer(mainPanel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command == "+ vGap") { // augment vGap
            changeGap(gridLayout.getVgap() + dram, gridLayout.getHgap());
        }
        if (command == "- vGap") {// abatement vGap
            changeGap(gridLayout.getVgap() - dram, gridLayout.getHgap());
        }
        if (command == "+ hGap") {// augment hGap
            changeGap(gridLayout.getVgap(), gridLayout.getHgap() + dram);
        }
        if (command == "- hGap") {// abatement hGap
            changeGap(gridLayout.getVgap(), gridLayout.getHgap() - dram);
        }
    }

    public static void main(String[] args) {
        new MyGridLayout();
    }
}