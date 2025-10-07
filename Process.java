public abstract class Process {
    protected int pid;
    protected String name;

    public Process(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ejecuta el proceso sin parámetros (modo por defecto).
     * Implementado polimórficamente en subclases.
     */
    public abstract String execute();

    /**
     * Ejecuta el proceso con un time slice o parámetro entero.
     * Algunas subclases pueden ignorar el parámetro.
     */
    public abstract String execute(int timeSlice);

    @Override
    public String toString() {
        return String.format("[%d] %s (%s)", pid, name, this.getClass().getSimpleName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Process)) return false;
        return this.pid == ((Process) obj).pid;
    }
}
