import java.util.ArrayList;
import java.util.List;

public class ProcessModel {
    private List<Process> procesos;

    public ProcessModel() {
        procesos = new ArrayList<>();
    }

    public void addProcess(Process p) {
        if (p != null && findByPid(p.getPid()) == null) {
            procesos.add(p);
        }
    }

    public boolean removeProcessByPid(int pid) {
        Process p = findByPid(pid);
        if (p != null) {
            return procesos.remove(p);
        }
        return false;
    }

    public List<Process> getAllProcesses() {
        return new ArrayList<>(procesos);
    }

    public Process findByPid(int pid) {
        for (Process p : procesos) {
            if (p.getPid() == pid) return p;
        }
        return null;
    }
}
