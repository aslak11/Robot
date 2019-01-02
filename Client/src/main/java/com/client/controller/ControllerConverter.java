package com.client.controller;

import net.java.games.input.Component;

import java.util.ArrayList;
import java.util.List;

public class ControllerConverter {

    Component component;

    public List<ControllerConverterData> list = new ArrayList<>();

    public enum ControllerConverterData {
        A_BTN,
        B_BTN,
        X_BTN,
        Y_BTN,
        SELECT_BTN,
        MODE_BTN,
        RIGHT_THUMB_BTN,
        LEFT_THUMB_BTN,
        RIGHT2_THUMB_BTN,
        LEFT2_THUMB_BTN,
        POV_CENTER,
        POV_UP_LEFT,
        POV_UP,
        POV_UP_RIGHT,
        POV_RIGHT,
        POV_DOWN_RIGHT,
        POV_DOWN,
        POV_DOWN_LEFT,
        POV_LEFT
    }

    public double X_AXIS = 0.0;
    public double Y_AXIS = 0.0;
    public double Z_AXIS = 0.0;
    public double RZ_AXIS = 0.0;
    public double RX_AXIS = 0.0;
    public double RY_AXIS = 0.0;


    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
        
        Component.Identifier identifier = component.getIdentifier();
        float data = component.getPollData();

        if (identifier.equals(Component.Identifier.Button.A)) {
            add(data, ControllerConverterData.A_BTN);
        } else if (identifier.equals(Component.Identifier.Button.B)) {
            add(data, ControllerConverterData.B_BTN);
        } else if (identifier.equals(Component.Identifier.Button.X)) {
            add(data, ControllerConverterData.X_BTN);
        } else if (identifier.equals(Component.Identifier.Button.Y)) {
            add(data, ControllerConverterData.Y_BTN);
        } else if (identifier.equals(Component.Identifier.Button.SELECT)) {
            add(data, ControllerConverterData.SELECT_BTN);
        } else if (identifier.equals(Component.Identifier.Button.MODE)) {
            add(data, ControllerConverterData.MODE_BTN);
        } else if (identifier.equals(Component.Identifier.Button.RIGHT_THUMB3)) {
            add(data, ControllerConverterData.RIGHT2_THUMB_BTN);
        } else if (identifier.equals(Component.Identifier.Button.LEFT_THUMB3)) {
            add(data, ControllerConverterData.LEFT2_THUMB_BTN);
        } else if (identifier.equals(Component.Identifier.Button.RIGHT_THUMB)) {
            add(data, ControllerConverterData.RIGHT_THUMB_BTN);
        } else if (identifier.equals(Component.Identifier.Button.LEFT_THUMB)) {
            add(data, ControllerConverterData.LEFT_THUMB_BTN);
        } else

        if (identifier.equals(Component.Identifier.Axis.POV)) {
            add(data, Component.POV.CENTER, ControllerConverterData.POV_CENTER);
            add(data, Component.POV.DOWN, ControllerConverterData.POV_DOWN);
            add(data, Component.POV.DOWN_LEFT, ControllerConverterData.POV_DOWN_LEFT);
            add(data, Component.POV.DOWN_RIGHT, ControllerConverterData.POV_DOWN_RIGHT);
            add(data, Component.POV.UP_RIGHT, ControllerConverterData.POV_UP_RIGHT);
            add(data, Component.POV.UP_LEFT, ControllerConverterData.POV_UP_LEFT);
            add(data, Component.POV.LEFT, ControllerConverterData.POV_LEFT);
            add(data, Component.POV.UP, ControllerConverterData.POV_UP);
            add(data, Component.POV.RIGHT, ControllerConverterData.POV_RIGHT);
        } else

        if (identifier.equals(Component.Identifier.Axis.X)) {
            X_AXIS = data;
        } else if (identifier.equals(Component.Identifier.Axis.Y)) {
            Y_AXIS = data;
        } else if (identifier.equals(Component.Identifier.Axis.Z)) {
            Z_AXIS = data;
        } else if (identifier.equals(Component.Identifier.Axis.RZ)) {
            RZ_AXIS = data;
        } else if (identifier.equals(Component.Identifier.Axis.RX)) {
            RX_AXIS = data;
        } else if (identifier.equals(Component.Identifier.Axis.RY)) {
            RY_AXIS = data;
        }

    }

    private void add(double data, ControllerConverterData controllerConverterData) {
        if (data == 1.0) {
            if (!list.contains(controllerConverterData)) {
                list.add(controllerConverterData);
            }
        } else {
            list.removeIf(x -> x.equals(controllerConverterData));
        }
    }

    private void add(float data, float pov, ControllerConverterData controllerConverterData) {
        if (data == pov) {
            if (!list.contains(controllerConverterData)) {
                list.add(controllerConverterData);
            }
        } else {
            list.removeIf(x -> x.equals(controllerConverterData));
        }
    }

    @Override
    public String toString() {
        String str = "";

        for (ControllerConverterData data : list) {
            str += data + "|";
        }

        str += "x," + X_AXIS + "|";
        str += "y," + Y_AXIS + "|";
        str += "z," + Z_AXIS + "|";
        str += "rz," + RZ_AXIS + "|";
        str += "rx," + RX_AXIS + "|";
        str += "ry," + RY_AXIS;


        return str;
    }
}
