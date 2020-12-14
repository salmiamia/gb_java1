package java2.lesson4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class Window extends JFrame {

    public Window() {
        setTitle("Пишем в файл из этого окна по нажатию кнопки Отправить или клавиши Enter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 660, 80);
        JButton button = new JButton("Отправить");
        JTextField field = new JTextField(45);

        // Слушатель по Enter
        field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(field.getText());
                Action.textWrite(Action.logFileName, field.getText());
                field.setText("");
            }
        });

        // Слушаетль по кнопке
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(field.getText());
                Action.textWrite(Action.logFileName, field.getText());
                field.setText("");
            }
        });

        // Создание панели с полем для ввода
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(field);
        contents.add(button);
        setContentPane(contents);
        setVisible(true);
    }

}