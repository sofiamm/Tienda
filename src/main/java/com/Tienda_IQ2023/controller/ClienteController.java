package com.Tienda_IQ2023.controller;

import com.Tienda_IQ2023.domain.Cliente;
import com.Tienda_IQ2023.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        //var clientes = clienteService.getClientes();
        //var clientes = clienteService.getClientePorNombre("Luis");
        var clientes = clienteService.getClientePorApellidos("Castro Mora");
        //var clientes = clienteService.getClientePorTelefono("5456-8789");
        model.addAttribute("listaClientes", clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/cliente/listado";
    }

}
