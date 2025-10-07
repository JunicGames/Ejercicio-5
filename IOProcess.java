public class IOProcess extends Process {
    private int ioWaitTime; // tiempo de espera simulado en "unidades"

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

    /**
     * Ejecuta en modo por defecto: el proceso entra en espera I/O.
     */
    @Override
    public String execute() {
        return String.format("%s solicita I/O -> BLOQUEADO por %d unidades", toString(), ioWaitTime);
    }

    /**
     * Ejecuta con un timeSlice: lo usamos como poll para simular que se revisa
     * si el dispositivo ya respondió.
     * Si timeSlice >= ioWaitTime asumimos que la I/O terminó.
     */
    @Override
    public String execute(int timeSlice) {
        if (timeSlice >= ioWaitTime) {
            return String.format("%s I/O atendida tras %d unidades -> LISTO", toString(), ioWaitTime);
        } else {
            return String.format("%s I/O parcialmente atendida (%d/%d) -> SIGUE BLOQUEADO", toString(),
                    timeSlice, ioWaitTime);
        }
    }

    /**
     * Método adicional (sobrecarga) para permitir polling booleano.
     */
    public String execute(boolean poll) {
        if (poll) {
            return execute(ioWaitTime); // forzamos chequear con full wait
        } else {
            return execute();
        }
    }
}
