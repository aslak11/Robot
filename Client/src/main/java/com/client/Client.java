package com.client;

import com.client.controller.ControllerConverter;
import com.client.window.MainWindow;
import net.java.games.input.*;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client extends SocketFunc {

    public static Socket socket;
    
    public Send send;
    public Controller1 controller1;
    
    public boolean d = true;

    public static boolean auto = false;
    static String current = "0";

    ControllerConverter controllerConverter = new ControllerConverter();

    MainWindow mainWindow;

    public static List<Character> currentKeys = new ArrayList<>();

    public Client() throws IOException {
        System.out.println(System.getProperty("java.library.path"));
        System.setProperty("java.library.path", "jinput-linux64");
        System.out.println(System.getProperty("java.library.path"));
        BasicConfigurator.configure();

        socket = new Socket("10.0.0.113", 1234);
        Send1 send1 = new Send1();
        mainWindow = new MainWindow(this, socket, send1);

        mainWindow.setVisible(true);
        currentKeys = mainWindow.keyListener_.currentKeys;

        controller1 = new Controller1(send1).start();
        send = new Send(send1).start();

        /*BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(socket.getInputStream()));
        File outputfile = new File("image.jpg");
        ImageIO.write(img, "jpg", outputfile);*/


    }

    public static void main(String[] args) throws IOException {
        new Client();

    }

    public class Controller1 implements Runnable {


        Send1 send2;

        public Controller1(Send1 send1) {
            this.send2 = send1;
        }

        @Override
        public void run() {

            Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
            for (Controller controller : controllers) {
                if (controller.getType().equals(Controller.Type.GAMEPAD)) {

                    EventQueue eventQueue = controller.getEventQueue();
                    Event event = new Event();
                    boolean stop = false;

                    for (Component component : controller.getComponents()) {
                        System.out.println(component.getName());
                    }

                    while (!stop) {
                        controller.poll();
                        eventQueue.getNextEvent(event);
                        Component component = event.getComponent();

                        controllerConverter.setComponent(component);
                        //System.out.println(controllerConverter.toString());

                        if (controllerConverter.list.contains(ControllerConverter.ControllerConverterData.A_BTN)) {
                            if (controllerConverter.Y_AXIS == -1.0) {
                                send2.setMsg("1");
                                d = false;
                            } else if (controllerConverter.Y_AXIS == 1.0) {
                                send2.setMsg("2");
                                d = false;
                            } else if (controllerConverter.X_AXIS == -1.0) {
                                send2.setMsg("3");
                                d = false;
                            } else if (controllerConverter.X_AXIS == 1.0) {
                                send2.setMsg("4");
                                d = false;
                            } else {
                                send2.setMsg("0");
                                d = true;
                            }
                        }
                    }
                }
            }

            t.stop();
        }

        public Thread t;
        public Controller1 start() {
            if (t == null) {
                t = new Thread (this);
                t.start ();
            }
            return this;
        }
    }

    public class Send1 {
        String msg = "";


        public synchronized String getMsg() {
            return msg;
        }

        public synchronized void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public class Send implements Runnable {

        Send1 send1;

        public Send(Send1 send1) {
            this.send1 = send1;
        }

        @Override
        public void run() {
            while (true) {
                if (!send1.getMsg().equals("")) {
                    try {
                        send(send1.getMsg(), socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public Thread t;
        public Send start() {
            if (t == null) {
                t = new Thread (this);
                t.start ();
            }
            return this;
        }
    }

    public static class Auto implements Runnable {

        @Override
        public void run() {
            boolean running = true;
            Run run = new Run();
            run.start();
            while (running) {
                //System.out.println(auto);

                try {
                    String csvStr = receive(socket);
                    if (!csvStr.equals("")) {
                        List<String> csv = new ArrayList<>(Arrays.asList(csvStr.split(",")));
                        if (csv.size() == 4) {
                            System.out.println(csvStr);
                            if (currentKeys.contains('c')) {
                                double dist1 = Double.parseDouble(csv.get(0));
                                double dist2 = Double.parseDouble(csv.get(1));
                                double dist3 = Double.parseDouble(csv.get(2));
                                double dist4 = Double.parseDouble(csv.get(3));

                                if (dist2 >= 30) {
                                    if (!current.equals("1")) {
                                        current = "1";
                                        send("1", socket);
                                    }
                                    //System.out.println(1);
                                } else {
                                    if (!current.equals("0")) {
                                        current = "0";
                                        send("0", socket);
                                    }
                                    //System.out.println(0);
                                }
                            } else {
                                current = "0";
                            }
                        }

                    }
                } catch (Exception e) {

                }

                if (!auto) {
                    running = false;
                    t.stop();
                    run.t.stop();
                }
            }
        }

        private Thread t;
        public void start() {
            if (t == null) {
                t = new Thread (this);
                t.start ();
            }
        }
    }

    static class Run implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (!current.equals("")) {
                    try {
                        send(current, socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public Thread t;
        public void start() {
            if (t == null) {
                t = new Thread (this);
                t.start ();
            }
        }
    }

    public static boolean check(int a, int b, int c) {
        return a<=b && b<=c;
    }

}
