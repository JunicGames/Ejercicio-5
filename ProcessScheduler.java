import java.util.ArrayList;
import java.util.List;

public class ProcessScheduler {
    private ProcessModel model;

    public ProcessScheduler(ProcessModel model) {
        this.model = model;
    }


    public List<String> runAll() {
        List<String> out = new ArrayList<>();
        for (Process p : model.getAllProcesses()) {
            out.add(p.execute());
        }
        return out;
    }

    public List<String> runAll(int timeSlice) {
        List<String> out = new ArrayList<>();
        for (Process p : model.getAllProcesses()) {
            out.add(p.execute(timeSlice));
        }
        return out;
    }

    public String runOne(int pid) {
        Process p = model.findByPid(pid);
        if (p == null) {
            return String.format("PID %d: no encontrado.", pid);
        }
        return p.execute();
    }
}
