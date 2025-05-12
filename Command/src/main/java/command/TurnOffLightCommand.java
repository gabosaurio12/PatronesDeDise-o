package command;

import receiver.Light;

// Apagar
public class TurnOffLightCommand implements Command {
    private Light light; // Referencia al receptor

    // Constructor que recibe el receptor
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    // Llama al receptor
    @Override
    public void execute() {
        light.turnOff(); // Apagamos la luz
    }
}
