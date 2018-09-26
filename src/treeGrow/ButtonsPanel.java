package treeGrow;

import treeGrow.View.CommandListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {

    CommandListener commandListener;


    public ButtonsPanel(CommandListener commandListener){

        JButton resetBtn = new JButton("Reset");
        JButton pauseBtn = new JButton("Pause");
        JButton playBtn = new JButton("Play");
        JButton endBtn = new JButton("End");


        this.add(resetBtn);
        this.add(pauseBtn);
        this.add(playBtn);
        this.add(endBtn);


        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandListener.onReset();
            }
        });

        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandListener.onPause();
            }
        });

        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandListener.onPlay();
            }
        });

        endBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandListener.onEnd();
            }
        });

    }

}
