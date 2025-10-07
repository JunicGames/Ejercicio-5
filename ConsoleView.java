import java.util.List;

public class ConsoleView {
    private ProcessModel model;

    public ConsoleView(ProcessModel model) {
        this.model = model;
    }

    public String renderProcessList() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Lista de procesos registrados ===\n");
        for (Process p : model.getAllProcesses()) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("=====================================");
        return sb.toString();
    }

    public String renderSchedulerOutput(List<String> out) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Salida del planificador ===\n");
        for (String s : out) {
            sb.append(s).append("\n");
        }
        sb.append("================================");
        return sb.toString();
    }

    public String renderSingle(String msg) {
        return ">>> " + msg;
    }
}
