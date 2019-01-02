/*
 * Created by JFormDesigner on Thu Dec 27 08:56:39 CET 2018
 */

package com.client.window;

import com.client.Client;
import com.client.SocketFunc;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.ds.ipcam.IpCamDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aslak Hellesund
 */
public class MainWindow extends JFrame {

    private final Client client;
    private final Socket socket;
    private final Client.Send1 send1;

    public KeyListener_ keyListener_;

    public MainWindow(Client client, Socket socket, Client.Send1 send1) {
        initComponents();
        setVisible(true);
        //show();

        this.client = client;
        this.socket = socket;
        this.send1 = send1;

        keyListener_ = new KeyListener_();

        addKeyListener(keyListener_);
    }

    public class KeyListener_ extends SocketFunc implements KeyListener {

        private boolean d;
        private boolean auto;

        public KeyListener_() {
            auto = client.auto;
            d = client.d;
        }

        public List<Character> currentKeys = new ArrayList<>();

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (!currentKeys.contains(keyEvent.getKeyChar())) {
                currentKeys.add(keyEvent.getKeyChar());
            }
            System.out.println(keyEvent);
            try {
                if (currentKeys.contains('w')) {
                    d = true;
                    if (currentKeys.contains('d')) {
                        send1.setMsg("12");
                    } else if (currentKeys.contains('a')) {
                        send1.setMsg("11");
                    } else {
                        send1.setMsg("1");
                    }
                } else if (currentKeys.contains('s')) {
                    if (currentKeys.contains('d')) {
                        send1.setMsg("13");
                    } else if (currentKeys.contains('a')) {
                        send1.setMsg("14");
                    } else {
                        send1.setMsg("2");
                    }
                    d = true;
                } else if (currentKeys.contains('d')) {
                    d = true;
                    send1.setMsg("3");
                } else if (currentKeys.contains('a')) {
                    d = true;
                    send1.setMsg("4");
                } else if (currentKeys.contains(' ')) {
                    send1.setMsg("0");
                    //d = true;
                    //auto = !auto;
                    new Client.Auto().start();
                } else {
                    d = false;
                    send1.setMsg("0");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            currentKeys.removeIf(x -> x.equals(keyEvent.getKeyChar()));
            send1.setMsg("0");
        }
    }


    private void thisWindowClosing(WindowEvent e) {
        try {
            client.controller1.t.stop();
            client.send.t.stop();
            client.send("/d/", socket);
            socket.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aslak Hellesund

        //======== this ========
        setMinimumSize(new Dimension(870, 420));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aslak Hellesund
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
