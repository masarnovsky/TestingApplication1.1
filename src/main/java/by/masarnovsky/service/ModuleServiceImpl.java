package by.masarnovsky.service;

import by.masarnovsky.dao.ModuleDAO;
import by.masarnovsky.model.Module;

import java.util.List;

public class ModuleServiceImpl implements ModuleService {
    ModuleDAO moduleDAO;

    public void setModuleDAO(ModuleDAO moduleDAO) {
        this.moduleDAO = moduleDAO;
    }

    public List<Module> getModules() {
        return moduleDAO.getModules();
    }
}
