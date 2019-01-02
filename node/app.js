var xbox = require('xbox-controller-node');
var net = require('net');
var client = new net.Socket();

client.connect(1234, '127.0.0.1', function () {
    console.log('Connected');

    var current = "NULL";

    xbox.on('a', function () {
        current = "A_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('b', function () {
        current = "B_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('y', function () {
        current = "Y_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('x', function () {
        current = "X_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('rb', function () {
        current = "RB_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('lb', function () {
        current = "LB_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('start', function () {
        current = "START_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('back', function () {
        current = "BACK_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('up', function () {
        current = "UP_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('down', function () {
        current = "DOWN_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('left', function () {
        current = "LEFT_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('right', function () {
        current = "RIGHT_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('upright', function () {
        current = "UPRIGHT_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('upleft', function () {
        current = "UPLEFT_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('downright', function () {
        current = "DOWNRIGHT_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('downleft', function () {
        current = "DOWNLEFT_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickpress', function () {
        current = "LEFTSTICK_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickpress', function () {
        current = "RIGHTSTICK_BUTTON_PRESS";
        console.log(current);
        send(current);
    });

    xbox.on('a:release', function () {
        current = "A_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('b:release', function () {
        current = "B_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('y:release', function () {
        current = "Y_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('x:release', function () {
        current = "X_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('rb:release', function () {
        current = "RB_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('lb:release', function () {
        current = "LB_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('start:release', function () {
        current = "START_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('back:release', function () {
        current = "BACK_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('up:release', function () {
        current = "UP_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('down:release', function () {
        current = "DOWN_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('left:release', function () {
        current = "LEFT_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('right:release', function () {
        current = "RIGHT_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('upright:release', function () {
        current = "UPRIGHT_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('upleft:release', function () {
        current = "UPLEFT_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('downright:release', function () {
        current = "DOWNRIGHT_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('downleft:release', function () {
        current = "DOWNLEFT_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickpress:release', function () {
        current = "LEFTSTICK_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickpress:release', function () {
        current = "RIGHTSTICK_BUTTON_PRESS_RELEASE";
        console.log(current);
        send(current);
    });

    /* Stick events */

    xbox.on('leftstickLeft', function () {
        current = "LEFTSTICK_MOVE_LEFT";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickRight', function () {
        current = "LEFTSTICK_MOVE_RIGHT";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickDown', function () {
        current = "LEFTSTICK_MOVE_DOWN";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickUp', function () {
        current = "LEFTSTICK_MOVE_UP";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickLeft', function () {
        current = "RIGHTSTICK_MOVE_LEFT";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickRight', function () {
        current = "RIGHTSTICK_MOVE_RIGHT";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickDown', function () {
        current = "RIGHTSTICK_MOVE_DOWN";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickUp', function () {
        current = "RIGHTSTICK_MOVE_UP";
        console.log(current);
        send(current);
    });

    /* Stick release events */

    xbox.on('leftstickLeft:release', function () {
        current = "LEFTSTICK_MOVE_LEFT_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickRight:release', function () {
        current = "LEFTSTICK_MOVE_RIGHT_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickDown:release', function () {
        current = "LEFTSTICK_MOVE_DOWN_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('leftstickUp:release', function () {
        current = "LEFTSTICK_MOVE_UP_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickLeft:release', function () {
        current = "RIGHTSTICK_MOVE_LEFT_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickRight:release', function () {
        current = "RIGHTSTICK_MOVE_RIGHT_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickDown:release', function () {
        current = "RIGHTSTICK_MOVE_UP_RELEASE";
        console.log(current);
        send(current);
    });

    xbox.on('rightstickUp:release', function () {
        current = "RIGHTSTICK_MOVE_DOWN_RELEASE";
        console.log(current);
        send(current);
    });

    /*while (true) {
        send(current);
    }*/

});

function send(msg) {
    console.log(msg);
    client.write(msg + "\n");
}