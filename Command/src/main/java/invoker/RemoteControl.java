package invoker;

import command.Command;

// invoker
public class RemoteControl {
    private Command command;

    // Establecer el comando que se ejecutará
    public void setCommand(Command command) {
        this.command = command;
    }

    // Presionar un botón y ejecutar el comando
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No hay comando asignado.");
        }
    }
}
