import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProcessModel model = new ProcessModel();
        ConsoleView view = new ConsoleView(model);
        ProcessScheduler scheduler = new ProcessScheduler(model);

        model.addProcess(new CPUProcess(1, "Compilador", 120));
        model.addProcess(new IOProcess(2, "LecturaDisco", 50));
        model.addProcess(new DaemonProcess(3, "LogMonitor"));
        model.addProcess(new CPUProcess(4, "Render", 80));
        model.addProcess(new IOProcess(5, "RedSocket", 30));

        System.out.println(view.renderProcessList());
        System.out.println();

        List<String> salidaDefault = scheduler.runAll();
        System.out.println(view.renderSchedulerOutput(salidaDefault));
        System.out.println();

        List<String> salidaTimeSlice = scheduler.runAll(40);
        System.out.println(view.renderSchedulerOutput(salidaTimeSlice));
        System.out.println();

        System.out.println(view.renderSingle(scheduler.runOne(1)));
        System.out.println(view.renderSingle(scheduler.runOne(999)));

        System.out.println();
        System.out.println("Estado final de procesos:");
        System.out.println(view.renderProcessList());
    }
}
