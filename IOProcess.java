public class IOProcess extends Process {
    private int ioWaitTime;

    public IOProcess(int pid, String name, int ioWaitTime) {
        super(pid, name);
        this.ioWaitTime = Math.max(0, ioWaitTime);
    }

    public int getIoWaitTime() {
        return ioWaitTime;
    }

    public void setIoWaitTime(int t) {
        this.ioWaitTime = Math.max(0, t);
    }

    @Override
    public String execute() {
        return String.format("%s solicita I/O -> BLOQUEADO por %d unidades", toString(), ioWaitTime);
    }

    @Override
    public String execute(int timeSlice) {
        if (timeSlice >= ioWaitTime) {
            return String.format("%s I/O atendida tras %d unidades -> LISTO", toString(), ioWaitTime);
        } else {
            return String.format("%s I/O parcialmente atendida (%d/%d) -> SIGUE BLOQUEADO", toString(),
                    timeSlice, ioWaitTime);
        }
    }

    public String execute(boolean poll) {
        if (poll) {
            return execute(ioWaitTime);
        } else {
            return execute();
        }
    }
}
