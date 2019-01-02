package com.server.controller;

public class ControllerConvert {

    public ControllerData controllerData = new ControllerData();
    public ControllerDataRaw controllerDataRaw;


    public ControllerConvert(String input) {
        if (!input.equals("") && input != null) {
            controllerDataRaw = ControllerDataRaw.valueOf(input);
            switch (controllerDataRaw) {
                case A_BUTTON_PRESS:
                    controllerData.A_BUTTON = true;
                    break;
                case B_BUTTON_PRESS:
                    controllerData.B_BUTTON = true;
                    break;
                case Y_BUTTON_PRESS:
                    controllerData.Y_BUTTON = true;
                    break;
                case X_BUTTON_PRESS:
                    controllerData.X_BUTTON = true;
                    break;
                case START_BUTTON_PRESS:
                    controllerData.START_BUTTON = true;
                    break;
                case LB_BUTTON_PRESS:
                    controllerData.LB_BUTTON = true;
                    break;
                case RB_BUTTON_PRESS:
                    controllerData.RB_BUTTON = true;
                    break;
                case UP_BUTTON_PRESS:
                    controllerData.UP_BUTTON = true;
                    break;
                case BACK_BUTTON_PRESS:
                    controllerData.BACK_BUTTON = true;
                    break;
                case DOWN_BUTTON_PRESS:
                    controllerData.DOWN_BUTTON = true;
                    break;
                case LEFT_BUTTON_PRESS:
                    controllerData.LEFT_BUTTON = true;
                    break;
                case LEFTSTICK_MOVE_UP:
                    controllerData.LEFTSTICK_MOVE_UP = true;
                    break;
                case RIGHT_BUTTON_PRESS:
                    controllerData.RIGHT_BUTTON = true;
                    break;
                case LEFTSTICK_MOVE_DOWN:
                    controllerData.LEFTSTICK_MOVE_DOWN = true;
                    break;
                case LEFTSTICK_MOVE_LEFT:
                    controllerData.LEFTSTICK_MOVE_LEFT = true;
                    break;
                case UPLEFT_BUTTON_PRESS:
                    controllerData.UPLEFT_BUTTON = true;
                    break;
                case LEFTSTICK_MOVE_RIGHT:
                    controllerData.LEFTSTICK_MOVE_RIGHT = true;
                    break;
                case RIGHTSTICK_MOVE_DOWN:
                    controllerData.RIGHTSTICK_MOVE_DOWN = true;
                    break;
                case RIGHTSTICK_MOVE_LEFT:
                    controllerData.RIGHTSTICK_MOVE_LEFT = true;
                    break;
                case UPRIGHT_BUTTON_PRESS:
                    controllerData.UPRIGHT_BUTTON = true;
                    break;
                case DOWNLEFT_BUTTON_PRESS:
                    controllerData.DOWNLEFT_BUTTON = true;
                    break;
                case RIGHTSTICK_MOVE_RIGHT:
                    controllerData.RIGHTSTICK_MOVE_RIGHT = true;
                    break;
                case RIGHTSTICK_MOVE_UP:
                    controllerData.RIGHTSTICK_MOVE_UP = true;
                    break;
                case DOWNRIGHT_BUTTON_PRESS:
                    controllerData.DOWNRIGHT_BUTTON = true;
                    break;
                case LEFTSTICK_BUTTON_PRESS:
                    controllerData.LEFTSTICK_BUTTON = true;
                    break;
                case RIGHTSTICK_BUTTON_PRESS:
                    controllerData.RIGHTSTICK_BUTTON = true;
                    break;


                case A_BUTTON_PRESS_RELEASE:
                    controllerData.A_BUTTON = false;
                    break;
                case B_BUTTON_PRESS_RELEASE:
                    controllerData.B_BUTTON = false;
                    break;
                case Y_BUTTON_PRESS_RELEASE:
                    controllerData.Y_BUTTON = false;
                    break;
                case X_BUTTON_PRESS_RELEASE:
                    controllerData.X_BUTTON = false;
                    break;
                case START_BUTTON_PRESS_RELEASE:
                    controllerData.START_BUTTON = false;
                    break;
                case LB_BUTTON_PRESS_RELEASE:
                    controllerData.LB_BUTTON = false;
                    break;
                case RB_BUTTON_PRESS_RELEASE:
                    controllerData.RB_BUTTON = false;
                    break;
                case UP_BUTTON_PRESS_RELEASE:
                    controllerData.UP_BUTTON = false;
                    break;
                case BACK_BUTTON_PRESS_RELEASE:
                    controllerData.BACK_BUTTON = false;
                    break;
                case DOWN_BUTTON_PRESS_RELEASE:
                    controllerData.DOWN_BUTTON = false;
                    break;
                case LEFT_BUTTON_PRESS_RELEASE:
                    controllerData.LEFT_BUTTON = false;
                    break;
                case LEFTSTICK_MOVE_UP_RELEASE:
                    controllerData.LEFTSTICK_MOVE_UP = false;
                    break;
                case RIGHT_BUTTON_PRESS_RELEASE:
                    controllerData.RIGHT_BUTTON = false;
                    break;
                case LEFTSTICK_MOVE_DOWN_RELEASE:
                    controllerData.LEFTSTICK_MOVE_DOWN = false;
                    break;
                case LEFTSTICK_MOVE_LEFT_RELEASE:
                    controllerData.LEFTSTICK_MOVE_LEFT = false;
                    break;
                case UPLEFT_BUTTON_PRESS_RELEASE:
                    controllerData.UPLEFT_BUTTON = false;
                    break;
                case LEFTSTICK_MOVE_RIGHT_RELEASE:
                    controllerData.LEFTSTICK_MOVE_RIGHT = false;
                    break;
                case RIGHTSTICK_MOVE_DOWN_RELEASE:
                    controllerData.RIGHTSTICK_MOVE_DOWN = false;
                    break;
                case RIGHTSTICK_MOVE_LEFT_RELEASE:
                    controllerData.RIGHTSTICK_MOVE_LEFT = false;
                    break;
                case UPRIGHT_BUTTON_PRESS_RELEASE:
                    controllerData.UPRIGHT_BUTTON = false;
                    break;
                case DOWNLEFT_BUTTON_PRESS_RELEASE:
                    controllerData.DOWNLEFT_BUTTON = false;
                    break;
                case RIGHTSTICK_MOVE_RIGHT_RELEASE:
                    controllerData.RIGHTSTICK_MOVE_RIGHT = false;
                    break;
                case RIGHTSTICK_MOVE_UP_RELEASE:
                    controllerData.RIGHTSTICK_MOVE_UP = false;
                    break;
                case DOWNRIGHT_BUTTON_PRESS_RELEASE:
                    controllerData.DOWNRIGHT_BUTTON = false;
                    break;
                case LEFTSTICK_BUTTON_PRESS_RELEASE:
                    controllerData.LEFTSTICK_BUTTON = false;
                    break;
                case RIGHTSTICK_BUTTON_PRESS_RELEASE:
                    controllerData.RIGHTSTICK_BUTTON = false;
                    break;
            }
        }
    }

}
