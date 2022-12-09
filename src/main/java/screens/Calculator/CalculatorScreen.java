package screens.Calculator;

import screens.Timer.LabelTextPanel;
import screens.Timer.TimerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

// Frameworks/Drivers layer

public class CalculatorScreen extends JPanel implements ActionListener {
    JLabel countDown = new JLabel("Your Historical Performance");
//    private long lastTickTime;
//    Timer timer = new Timer(1, this::actionPerformed);
//    JTextField timerDuration = new JTextField(15);

    public OutPutHistogram calculatorController;

    /**
     * A window with a title and a JButton.
     */
    public CalculatorScreen(OutPutHistogram controller) {

        this.calculatorController = controller;
        this.countDown.setAlignmentX(Component.CENTER_ALIGNMENT);



        JButton start = new JButton("Launch the Graph");

        JPanel buttons = new JPanel();
        //buttons.add(timerLabel);
        buttons.add(this.countDown);
        buttons.add(start);
        start.addActionListener(this::actionPerformed);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(buttons);

    }



    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

//        timerController.create(Duration.ofMinutes(durationOfTimer));
//        timer.stop();
        System.out.println("trying");

    }
   }