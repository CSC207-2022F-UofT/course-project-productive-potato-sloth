package screens.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

// Frameworks/Drivers layer

public class TimerScreen extends JPanel implements ActionListener {

    JLabel countDown = new JLabel("00:00:00");
    private long lastTickTime = 0;
    Timer timer = new Timer(1, this::actionPerformed);
    JTextField timerDuration = new JTextField(15);
    LocalDateTime restartTime;
    int flag = 0;
    TimerController timerController;

    /**
     * A window with a title and a JButton.
     */
    public TimerScreen(TimerController controller) {

        this.timerController = controller;
        this.countDown.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel userInput = new LabelTextPanel(new JLabel("Enter Duration (in whole number of minutes)"), timerDuration);
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
     * Action Listener associated with the Timer. It keeps the countdown going after the start button is pressed.
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


    /**
     * Action Listener associated with the Start Button.
     * When user presses the start button, it calls start method of java swing timer that triggers the countdown.
     */
    public void actionPerformedStart(ActionEvent evt) {


        if (!this.timer.isRunning() && lastTickTime != 0) {
            timer.start();
            flag = 2;
            this.restartTime = LocalDateTime.now();
        }

        else {
            try {
                Long durationOfTimer = Long.parseLong(timerDuration.getText());
                Long durationInMillis = Long.parseLong(timerDuration.getText()) * 60000;
                if (durationOfTimer < 0){
                    JOptionPane.showMessageDialog(this, "Enter positive whole number!\nTime Travel is not possible for now.");
                }
                timerController.create(Duration.ofMinutes(durationOfTimer));
                if (!this.timer.isRunning()) {
                    this.lastTickTime = durationInMillis;
                    timer.start();
                    flag = 1;
                }
                }
            catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Enter whole number!");
                System.out.println("Enter whole number!");
            }
            }


    }

    /**
     * Action Listener associated with the Pause Button.
     * When user presses the pause button, it calls stop method of java swing timer that halts the countdown.
     */
    public void actionPerformedPause(ActionEvent evt) {
        if (flag == 1) {
            timerController.pause();
            timer.stop();
            flag = 0;
        } else if (flag == 2) {
            timerController.pause(restartTime);
            timer.stop();
            flag = 0;
        }
    }

}