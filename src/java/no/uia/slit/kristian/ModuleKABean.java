package no.uia.slit.kristian;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import no.uia.slit.web.Page;


/**
 *
 * @author even
 */
@Named("moduleKABean")
@ConversationScoped
public class ModuleKABean implements Serializable {
    @EJB 
    private ModuleKAPersistenceService moduleSvc;
    private ModuleKA selectedModule;

    public ModuleKABean() {
    }


    public List<ModuleKA> getAllModulesKA() {
        return moduleSvc.findAll();
    }

    /** Set up module form for adding a new module */
    public Page createModule() {
        ModuleKA module = new ModuleKA();
        module.setId(22);
        module.setLearningObjectives("Learn without knowledge");
        
        moduleSvc.save(module);

        return Page.module;
    }

    /** Prepare module form for editing an existing module.
     * If the requested module does not exist, a new module
     * will be created instead. */
    public Page editModule(long id) {
        selectedModule = moduleSvc.find(id);
        if (null == selectedModule) {
            selectedModule = new ModuleKA();
        }
        return Page.module;
    }

    public ModuleKA getSelectedModule() {
        return selectedModule;
    }
}