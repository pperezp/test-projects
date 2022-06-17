package cl.spring.course.controller;

import cl.spring.course.domain.President;
import cl.spring.course.service.PresidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/president")
public class PresidentController {

    @Autowired
    private PresidentService presidentService;

    @GetMapping()
    public String index(Model model){
        Iterable<President> presidents =  presidentService.read();

        model.addAttribute("presidents", presidents);

        return "president";
    }

    /**
     * Método que carga la vista modify-president.html
     * al llamar a la url /president/create
     *
     * @param president Éste es el objeto que queda unido al formulario
     * @return El nombre de la vista
     */
    @GetMapping("/create")
    public String create(President president){
        return "modify-president";
    }

    /**
     * Método que se llama desde el formulario.
     * @param president Recibe como parámetro el presidente con
     *                  todos los datos del formulario
     * @return la redirección hacia la vista donde carga a todos
     * los presidentes desde la base de datos
     */
    @PostMapping("/save")
    public String save(President president){
        presidentService.save(president);

        return "redirect:/president";
    }

    /**
     *
     * @param president El id entregado como PathVariable, se almacena
     *                  automáticamente en el objeto president pasado
     *                  por parámetro
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(President president, Model model){
        // Rescatamos el objeto
        president = presidentService.readById(president.getId());

        // Compartimos el objeto
        model.addAttribute("president", president);

        // Llamamos a la vista
        return "modify-president";
    }

    @GetMapping("/delete/{id}")
    public String delete(President president){
        presidentService.delete(president);

        return "redirect:/president";
    }
}
