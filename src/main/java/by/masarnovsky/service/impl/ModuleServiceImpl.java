package by.masarnovsky.service.impl;

import by.masarnovsky.dao.ModuleDAO;
import by.masarnovsky.model.Module;
import by.masarnovsky.service.ModuleService;

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
