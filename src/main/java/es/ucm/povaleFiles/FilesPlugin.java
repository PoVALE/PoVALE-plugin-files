/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ucm.povaleFiles;

import es.ucm.povale.entity.Entity;
import es.ucm.povaleFiles.entities.Directory;
import es.ucm.povaleFiles.entities.File;
import es.ucm.povaleFiles.functions.BaseName;
import es.ucm.povaleFiles.functions.Children;
import es.ucm.povaleFiles.functions.ChildrenRec;
import es.ucm.povaleFiles.functions.Extension;
import es.ucm.povaleFiles.functions.Files;
import es.ucm.povaleFiles.functions.FilesRec;
import es.ucm.povaleFiles.functions.IsDirectory;
import es.ucm.povaleFiles.functions.Name;
import java.util.Arrays;
import java.util.List;
import es.ucm.povale.function.Function;
import es.ucm.povale.parameter.ParameterEditor;
import es.ucm.povale.plugin.PluginInfo;
import es.ucm.povale.predicate.Predicate;
import java.util.Map;

/**
 *
 * @author manuel
 */
public class FilesPlugin extends PluginInfo {
    public static String FILES_ID_PLUGIN = "es.ucm.povale.FilesPlugin";
    

    @Override
    public String getIdPlugin() {
        return FILES_ID_PLUGIN;
    }

    @Override
    public List<Function> getFunctions() {
        return Arrays.asList(
                new BaseName(), 
                new Children(), 
                new ChildrenRec(),
                new Extension(),
                new Files(),
                new FilesRec(),
                new Name()
        );
    }

    @Override
    public List<Predicate> getPredicates() {
        return Arrays.asList(
                new IsDirectory()
        );
    }

    @Override
    public List<Class<?>> getEntities() {
        return Arrays.asList(
                File.class,
                Directory.class
        );
    }

    @Override
    public List<String> getEditorTypes() {
        return Arrays.asList("FileEntity","DirectoryEntity");
    }
    
     @Override
    public ParameterEditor<? extends Entity> getEditor(String name, Map<String,String> parameters){
        if("FileEntity".equals(name)){
            return new DirectoryEditor(parameters);
        }
            
        else if("DirectoryEntity".equals(name)){
            return new FileEditor(parameters);
        }
        
        return null;
    }
    

    
}
