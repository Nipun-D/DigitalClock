package com.nipun;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock {

    private static JFrame frame;
    private static SimpleDateFormat timeFormat, dayFormat, dateFormat;
    private static JLabel timeLabel, dayLabel, dateLabel ;
    private static String time, date, day;

    public static void main(String[] args) {

        frame = new JFrame("Digital Clock");

        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.BLACK);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.RED);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        frame.add(timeLabel);

        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        frame.add(dayLabel);

        dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        frame.add(dateLabel);

        frame.setVisible(true);

        setTime();

    }

    public static void setTime(){
        while (true) {

            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time); //Setting the time to current time

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day); //Setting the day to current day

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date); //Setting the date to current date

            try {
                Thread.sleep(1000); //While loop is carried out every second to update the clock
            } catch (InterruptedException e) {
                e.printStackTrace(); //Catching an exception
            }

        }
    }

}
