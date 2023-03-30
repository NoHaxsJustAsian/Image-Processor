package view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;



public class GUIView extends JFrame implements IImageProcessorView {

  private JLabel label;
  private JTextField textField;

  private JButton RedFilterButton;
  private JButton GreenFilterButton;


  public GUIView() {
    super();

    this.setSize(420, 420);
    this.setTitle("Image Processor");
    this.setLocation(0, 0);

    this.setMinimumSize(new Dimension(420, 420));
    this.getContentPane().setBackground(Color.WHITE);


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());

    this.label = new JLabel("Image Processor");
    this.add(label);

    this.textField = new JTextField(25);
    this.add(this.textField);

    RedFilterButton = new JButton("Red");
    RedFilterButton.setActionCommand("Red Button");
    this.add(RedFilterButton);



    this.pack();
    this.setVisible(true);
  }




  @Override
  public void renderMessage(String message) throws IOException {

  }

  @Override
  public void renderState() throws IOException {

  }



}
