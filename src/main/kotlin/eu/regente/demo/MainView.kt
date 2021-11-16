package eu.regente.demo

import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
class MainView : VerticalLayout() {
    init {
        val greetService = GreetService()
        val textField = TextField("Your name")

        // Button click listeners can be defined as lambda expressions

        val button =
            Button("Say hello!") { Notification.show(greetService.greet(textField.value)) }.apply {
                addThemeVariants(ButtonVariant.LUMO_PRIMARY)
                addClickShortcut(Key.ENTER)
            }

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content")
        add(textField, button)
    }
}

