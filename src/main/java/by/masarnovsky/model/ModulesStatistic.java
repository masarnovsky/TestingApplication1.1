package by.masarnovsky.model;

public class ModulesStatistic {
    private Integer id;
    private String module;
    private Integer peoples;
    private Integer passed;
    private Integer failed;

    public Integer getId() {
        return id;
    }

    public String getModule() {
        return module;
    }

    public Integer getPeoples() {
        return peoples;
    }

    public Integer getPassed() {
        return passed;
    }

    public Integer getFailed() {
        return failed;
    }

    public ModulesStatistic(Integer id, String module, Integer peoples, Integer passed, Integer failed) {
        this.id = id;
        this.module = module;
        this.peoples = peoples;
        this.passed = passed;
        this.failed = failed;
    }
}
