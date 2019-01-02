package com.server;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Server {

    private static Serial serial;

    private static ServerSocket serverSocket;
    private static Serial serialSen;

    static boolean serialSenConnected = false;
    static boolean serialConnected = false;

    public static void main(String[] args) {

        try {
            serial = SerialFactory.createInstance();
            serial.open("/dev/ttyUSB0", 9600);
            serialConnected = true;
        } catch (IOException e) {
            serialConnected = false;
        }
        try {
            serialSen = SerialFactory.createInstance();
            serialSen.open("/dev/ttyACM0", 9600);
            serialSenConnected = true;
        } catch (IOException e) {
            serialSenConnected = false;
        }
        System.out.println(serialSenConnected);


        /*Gpio.wiringPiSetup();

        int n = 1;
        Gpio.pinMode(n, Gpio.PWM_OUTPUT);
        Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
        Gpio.pwmSetClock(192);
        Gpio.pwmSetRange(2000);

        try {
            for(int i = 0; i < 5; i++){
                System.out.println("Set Servo");
                Gpio.pwmWrite(n, 1);

                Thread.sleep(1000);

                System.out.println("Change servo state...");
                Gpio.pwmWrite(n, 250);

                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GpioFactory.getInstance().shutdown();*/

        try {
            serial.writeln("0");

            serverSocket = new ServerSocket(1234);
            while (true){
                try {
                    final Socket client = serverSocket.accept();
                    System.out.println(client.getRemoteSocketAddress() + " : connected");

                    serial.addListener(new SerialDataEventListener() {
                        @Override
                        public void dataReceived(SerialDataEvent event) {
                            try {
                                String str = event.getString(Charset.forName("UTF-8"));
                                //out.println(str);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    serialSen.addListener(new SerialDataEventListener() {
                        @Override
                        public void dataReceived(SerialDataEvent event) {
                            try {
                                String str = event.getString(Charset.defaultCharset());
                                System.out.println(str);
                                int i = new ArrayList<>(Arrays.asList(str.split(","))).size();
                                if (i == 4) {
                                    send(str, client);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    boolean running = true;
                    while (running) {
                        String req = receive(client);
                        if (req.contains("/d/")) {
                            client.close();
                            running = false;
                            System.out.println(client.getRemoteSocketAddress() + " : disconnected");
                        } else if (req.contains("/servo/x/")) {
                            req = req.replace("/servo/x/", "");

                        } else {
                            serial.writeln(req);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(String m, Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(m);
    }

    public static String receive(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return in.readLine();
    }

}
