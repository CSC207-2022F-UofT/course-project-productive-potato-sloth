package screens.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

// Frameworks/Drivers layer

public class TimerScreen extends JPanel implements ActionListener {
    JLabel countDown = new JLabel("00:00:00");
    private long lastTickTime;
    Timer timer = new Timer(1, this::actionPerformed);
    JTextField timerDuration = new JTextField(15);
    /**
     * The input duration of the timer
     */

    /**
     * The controller
     */
    TimerController timerController;

    /**
     * A window with a title and a JButton.
     */
    public TimerScreen(TimerController controller) {

        this.timerController = controller;
        this.countDown.setAlignmentX(Component.CENTER_ALIGNMENT);



        LabelTextPanel userInput = new LabelTextPanel(new JLabel("Enter Duration (in minutes)"), timerDuration);
        JButton start = new JButton("Start");
        JButton pause = new JButton("Pause");

        JPanel buttons = new JPanel();
        //buttons.add(timerLabel);
        buttons.add(this.countDown);
        buttons.add(start);
        buttons.add(pause);

        start.addActionListener(this::actionPerformedStart);
        pause.addActionListener(this::actionPerformedPause);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(this.countDown);
        this.add(userInput);
        this.add(buttons);

    }



    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        if(this.lastTickTime<0){
            this.countDown.setText("00:00:00");
            timer.stop();
        }
        else {
            long runningTime = this.lastTickTime - 1;
            lastTickTime -= 1;
            Duration duration = Duration.ofMillis(runningTime);

            long minutes = duration.toMinutes();
            duration = duration.minusMinutes(minutes);
            long millis = duration.toMillis();
            long seconds = millis / 1000;
            millis -= (seconds * 1000);
            this.countDown.setText(String.format("%02d:%02d:%03d", minutes, seconds, millis));
        }

    }
    public void actionPerformedStart(ActionEvent evt) {


        if (!this.timer.isRunning() && lastTickTime != 0) {
            timer.start();
        }

        else {
            System.out.println("Click " + evt.getActionCommand());
            Long durationOfTimer = Long.parseLong(timerDuration.getText());
            Long durationInMillis = Long.parseLong(timerDuration.getText())*60000;

            timerController.create(Duration.ofMinutes(durationOfTimer));
            if (!this.timer.isRunning()) {
            this.lastTickTime = durationInMillis;
            timer.start();


            }
        }

    }
    public void actionPerformedPause(ActionEvent evt) {

        Long durationOfTimer=Long.parseLong(timerDuration.getText());
        timerController.create(Duration.ofMinutes(durationOfTimer));
        timer.stop();

    }

}