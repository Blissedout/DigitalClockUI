package digitalclockui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private JFrame frame;
    private JLabel timeLabel;

    public Clock() {
        frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(timeLabel);

        updateTime();

        frame.setVisible(true);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a, MMMM dd, yyyy");
        String formattedTime = now.format(formatter);
        timeLabel.setText(formattedTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Clock::new);
    }
}