import java.util.ArrayList;
import java.util.List;

public class ProcessScheduler {
    private ProcessModel model;

    public ProcessScheduler(ProcessModel model) {
        this.model = model;
    }

    /**
     * Ejecuta todos los procesos usando la sobrecarga por defecto.
     * Retorna lista de mensajes (no imprime).
     */
    public List<String> runAll() {
        List<String> out = new ArrayList<>();
        for (Process p : model.getAllProcesses()) {
            out.add(p.execute());
        }
        return out;
    }

    /**
     * Ejecuta todos los procesos usando un timeSlice entero.
     * Cada proceso decide cómo interpretar el timeSlice (polimorfismo).
     */
    public List<String> runAll(int timeSlice) {
        List<String> out = new ArrayList<>();
        for (Process p : model.getAllProcesses()) {
            out.add(p.execute(timeSlice));
        }
        return out;
    }

    /**
     * Ejecuta un solo proceso identificado por pid (si existe).
     */
    public String runOne(int pid) {
        Process p = model.findByPid(pid);
        if (p == null) {
            return String.format("PID %d: no encontrado.", pid);
        }
        return p.execute();
    }
}
