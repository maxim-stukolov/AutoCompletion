package controllers;

import entity.Table1;
import facade.TableFacade;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name="testController")
@SessionScoped
public class TestController {
    private static Logger _log = Logger.getLogger(TestController.class.getName());

    public String message;
    public List<Table1> table1List;
    public Table1 selected;
    private boolean visible = false;
    List<Table1> users;
    public String newValue;
    @EJB
    private TableFacade tableFacade;

    @PostConstruct
    public void init(){
        message = "PrimaryFases";
        table1List = new ArrayList<Table1>();
        table1List = getTableFacade().findAll();
        selected = table1List.get(0);
        newValue = "rrrrr";
    }
    public List<Table1> completeUsers(String query) {
        List<Table1> suggestions = new ArrayList<Table1>();
        table1List = getTableFacade().findAll();
        for(Table1 p : table1List) {
            if(p.getName().startsWith(query))
                suggestions.add(p);
        }

        return suggestions;
    }
    public List<String> completeUsersStr(String query) {
        List<String> suggestions = new ArrayList<String>();
        table1List = getTableFacade().findAll();
        for(Table1 p : table1List) {
            if(p.getName().startsWith(query))
                suggestions.add(p.getName());
        }
        return suggestions;
    }
    public void handleSelect(SelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected:" + event.getObject().toString(), null);

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void saveUser(){
        if(tableFacade.findName(getNewValue()) == null){

            addMessage("Пользователь сохранен: " + getNewValue());
        }  else {
            addMessage("Пользователь существует: ");
        }
    }

    public void onClick(){
        setVisible(true);
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Table1> getTable1List() {
        return table1List;
    }

    public void setTable1List(List<Table1> table1List) {
        this.table1List = table1List;
    }

    public TableFacade getTableFacade() {
        return tableFacade;
    }

    public void setTableFacade(TableFacade tableFacade) {
        this.tableFacade = tableFacade;
    }

    public Table1 getSelected() {
        return selected;
    }

    public void setSelected(Table1 selected) {
        this.selected = selected;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
