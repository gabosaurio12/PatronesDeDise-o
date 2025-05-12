package main;

import command.Command;
import command.TurnOffLightCommand;
import command.TurnOnLightCommand;
import invoker.RemoteControl;
import receiver.Light;

public class Main {
    public static void main(String[] args) {

        // Se crea el receptor: la luz
        Light light = new Light();

        // Se crean los comandos concretos con el receptor como parámetro
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        // Se crea el invocador (control remoto)
        RemoteControl remote = new RemoteControl();

        // Asignamos el comando de encender la luz
        remote.setCommand(turnOn);
        remote.pressButton();

        // Asignamos el comando de apagar la luz
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
