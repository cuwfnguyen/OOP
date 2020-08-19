package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CalcutateDemo extends JFrame implements ActionListener{
    SoNguyen soNguyen = new SoNguyen();
    String result;
    private JButton btnOK;
    private JTextField tf1, tf2;
    /*Dùng để nhận tầng ContentPane của JFrame*/
    private Container container;

    private JPanel panel1, panel2;

    /*Hàm khởi tạo với một tham số là String s*/
    public CalcutateDemo(String s) {
        super(s);
        /*Lấy lớp ContentPane để đặt các đối tượng hiển thị*/
        container = this.getContentPane();

        /*Tạo các thành phần trên giao diện*/
        JLabel field1 = new JLabel("Nhập biểu thức: ");
        tf1 = new JTextField();
        JLabel field2 = new JLabel("Kết quả ");
        tf2 = new JTextField();
        tf2.setEditable(false);


        /*Panel1 chứa 3 Textfield*/
        panel1 = new JPanel();
        /*thiết lập Layout gồm 2 hàng 2 cột*/
        panel1.setLayout(new GridLayout(2,2));
        /*Đặt các thành phần vào panel 1*/
        panel1.add(field1);
        panel1.add(tf1);
        panel1.add(field2);
        panel1.add(tf2);
        /*Tạo 4 nút biểu diễn 4 phép toán*/
        btnOK = new JButton("OK");
        /*Panel2 chứa 4 nút*/
        panel2 = new JPanel();
        panel2.add(btnOK);

        /*Đặt 2 panel vào ContentPane*/
        container.add(panel1);
        container.add(panel2,"South");

        btnOK.addActionListener(this);

        /*Thiết lập kích thước hiển thị*/
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }


    /*Bắt đầu tính toán khi người dùng ấn các nút phép toán*/
    public void actionPerformed(ActionEvent e)
    {
            //Xử lý trường hợp chưa nhập Biểu thức nhưng đã bấm tính toán
            if(tf1.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ");
            }else{
                result=tf1.getText();
                soNguyen.setMathExpression(result);
                String[] elementMath = soNguyen.processString(soNguyen.getMathExpression());
                elementMath = soNguyen.postfix(elementMath);     //  dua cac phan tu ve dang hau to
                tf2.setText(soNguyen.valueMath(elementMath));
        }
    }

    public static void main(String[] args) {
        CalcutateDemo cal = new CalcutateDemo("SimpleCalculator");
        cal.setLocationRelativeTo(null);
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
