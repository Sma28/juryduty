package com.mps.juryduty.spring.views.form;

import com.mps.juryduty.spring.backend.Employee;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.mps.juryduty.spring.MainView;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

@Route(value = "form", layout = MainView.class)
@PageTitle("Form")
@CssImport("styles/views/form/form-view.css")
public class FormView extends Div {

    private TextField rounds = new TextField();
    private TextField sets = new TextField();
    private TextField contestant = new TextField();
    private Select<String> juryBoss = new Select<>();
    private CheckboxGroup<String> jury = new CheckboxGroup();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    public FormView() {
        setId("form-view");
        VerticalLayout wrapper = createWrapper();

        juryBoss.setItems(new ArrayList<String>(){
            {
                add("Alex Telehoi");
                add("Smaranda Alexandru");
            }
        });

        jury.setItems(new ArrayList<String>(){
            {
                add("Alex Telehoi");
                add("Smaranda Alexandru");
            }
        });

        createTitle(wrapper);
        createFormLayout(wrapper);
        createButtonLayout(wrapper);

        // Configure Form
        Binder<Employee> binder = new Binder<>(Employee.class);

        // Bind fields. This where you'd define e.g. validation rules
        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> binder.readBean(null));
        save.addClickListener(e -> {
            Notification.show("Not implemented");
            save.getUI().ifPresent(ui -> {
                ui.navigate("dashboard");
            });
            this.setVisible(false);
        });
        add(wrapper);
    }

    private void createTitle(VerticalLayout wrapper) {
        H1 h1 = new H1("Form");
        wrapper.add(h1);
    }

    private VerticalLayout createWrapper() {
        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setId("wrapper");
        wrapper.setSpacing(false);
        return wrapper;
    }

    private void createFormLayout(VerticalLayout wrapper) {
        FormLayout formLayout = new FormLayout();
        addFormItem(wrapper, formLayout, rounds, "Rounds");
        addFormItem(wrapper, formLayout, sets, "Sets");
        FormLayout.FormItem contestantsFormItem = addFormItem(wrapper, formLayout,
                contestant, "Contestants");
        //formLayout.setColspan(emailFormItem, 2);
        FormLayout.FormItem juryFormItem = addFormItem(wrapper, formLayout,
                jury, "Jury");
        FormLayout.FormItem juryBossFormItem = addFormItem(wrapper, formLayout,
                juryBoss, "Jury Boss");
        //formLayout.setColspan(notesFormItem, 2);
    }

    private void createButtonLayout(VerticalLayout wrapper) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        buttonLayout.setWidthFull();
        buttonLayout
                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(cancel);
        buttonLayout.add(save);
        wrapper.add(buttonLayout);
    }

    private FormLayout.FormItem addFormItem(VerticalLayout wrapper,
            FormLayout formLayout, Component field, String fieldName) {
        FormLayout.FormItem formItem = formLayout.addFormItem(field, fieldName);
        wrapper.add(formLayout);
        field.getElement().getClassList().add("full-width");
        return formItem;
    }

}
