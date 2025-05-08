package command;

import receiver.Light;

// Encender
public class TurnOnLightCommand implements Command {
    private Light light; // Referencia al receptor

    // Constructor que recibe el receptor
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    // Llama al receptor
    @Override
    public void execute() {
        light.turnOn(); // Encendemos la luz
    }
}

