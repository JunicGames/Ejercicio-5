public class DaemonProcess extends Process {
    private boolean active;

    public DaemonProcess(int pid, String name) {
        super(pid, name);
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean a) {
        this.active = a;
    }

    @Override
    public String execute() {
        if (active) {
            return String.format("%s daemon corriendo en background -> OK", toString());
        } else {
            return String.format("%s daemon inactivo", toString());
        }
    }

    @Override
    public String execute(int timeSlice) {
        // El daemon ignora el time slice y sigue funcionando
        return execute();
    }
}
