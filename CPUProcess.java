public class CPUProcess extends Process {
    private int requiredCycles; // ciclos restantes

    public CPUProcess(int pid, String name, int requiredCycles) {
        super(pid, name);
        this.requiredCycles = Math.max(0, requiredCycles);
    }

    public int getRequiredCycles() {
        return requiredCycles;
    }

    public void setRequiredCycles(int c) {
        this.requiredCycles = Math.max(0, c);
    }

    /**
     * Ejecuta el proceso por completo (consume todos los ciclos).
     */
    @Override
    public String execute() {
        int consumed = requiredCycles;
        requiredCycles = 0;
        return String.format("%s ejecutado: consumidos %d ciclos -> COMPLETADO", toString(), consumed);
    }

    /**
     * Ejecuta el proceso durante un time slice (si hay más ciclos, queda pendiente).
     */
    @Override
    public String execute(int timeSlice) {
        if (timeSlice <= 0) {
            return String.format("%s: timeSlice inválido (%d). No se ejecuta.", toString(), timeSlice);
        }
        int before = requiredCycles;
        int consumed = Math.min(timeSlice, requiredCycles);
        requiredCycles -= consumed;

        if (requiredCycles == 0) {
            return String.format("%s ejecutado %d ciclos (de %d) -> COMPLETADO", toString(), consumed, before);
        } else {
            return String.format("%s ejecutado %d ciclos (de %d) -> QUEDAN %d ciclos", toString(),
                    consumed, before, requiredCycles);
        }
    }
}
