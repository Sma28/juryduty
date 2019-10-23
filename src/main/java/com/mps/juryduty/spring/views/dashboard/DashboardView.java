package com.mps.juryduty.spring.views.dashboard;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import com.mps.juryduty.spring.backend.BackendService;
import com.mps.juryduty.spring.backend.Employee;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import com.mps.juryduty.spring.MainView;

@Route(value = "dashboard", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Dashboard")
@CssImport("styles/views/dashboard/dashboard-view.css")
public class DashboardView extends Div implements AfterNavigationObserver {

    @Autowired
    private BackendService service;
    //private final Grid<Employee> grid;
    private final VerticalLayout verticalLayout;

    public DashboardView() {
        setId("dashboard-view");
//        grid = new Grid<>();
//        grid.setId("list");
//        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
//                GridVariant.LUMO_NO_ROW_BORDERS);
//        grid.setHeightFull();
//        grid.addColumn(new ComponentRenderer<>(employee -> {
//            H3 h3 = new H3(
//                    employee.getLastname() + ", " + employee.getFirstname());
//            Anchor anchor = new Anchor("mailto:" + employee.getEmail(),
//                    employee.getEmail());
//            anchor.getElement().getThemeList().add("font-size-xs");
//            Div div = new Div(h3, anchor);
//            div.addClassName("employee-column");
//            return div;
//        }));
//
//        add(grid);
        Button signUpJury = new Button();
        Button signUpOrganizer = new Button();
        Button logInJury = new Button();
        Button logInOrganizer = new Button();
//        signUpJury.getElement().getStyle().set("margin-left", "auto");
//        signUpOrganizer.getElement().getStyle().set("margin-left", "auto");
//        logInJury.getElement().getStyle().set("margin-left", "auto");
//        logInOrganizer.getElement().getStyle().set("margin-left", "auto");
        HorizontalLayout logIn = new HorizontalLayout();
        logIn.setMargin(true);
        logIn.setPadding(true);
        logIn.setSpacing(true);
        HorizontalLayout signUp = new HorizontalLayout();
        signUp.setMargin(true);
        signUp.setPadding(true);
        signUp.setSpacing(true);
        logIn.add(logInJury);
        logIn.add(logInOrganizer);
        signUp.add(signUpJury);
        signUp.add(signUpOrganizer);
//        logIn.getElement().getStyle().set("margin-top", "auto");
//        signUp.getElement().getStyle().set("margin-top", "auto");
        verticalLayout = new VerticalLayout();
        verticalLayout.add(logIn);
        verticalLayout.add(signUp);
        verticalLayout.setSizeUndefined();
        verticalLayout.setMargin(true);
        verticalLayout.setPadding(true);
        verticalLayout.setSpacing(true);

        add(verticalLayout);

    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        //grid.setItems(service.getEmployees());
    }
}
