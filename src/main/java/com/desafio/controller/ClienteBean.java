package com.desafio.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.desafio.dto.EnderecoDTO;
import com.desafio.model.Cliente;
import com.desafio.service.ClienteService;
import com.desafio.service.ViaCepService;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Controller
@Scope("session")
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ClienteService clienteService;

    @Autowired
    private ViaCepService viaCepService;

    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;

    @NotEmpty(message = "O campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "O campo email é obrigatório")
    @Email(message = "O email informado não é válido")
    private String email;

    public void consultarEnderecoPorCep() {
        if (cliente.getCep() != null && !cliente.getCep().isEmpty()) {
            EnderecoDTO endereco = viaCepService.consultarEnderecoPorCep(cliente.getCep());
            if (endereco != null) {
                cliente.setEndereco(endereco.getLogradouro());
                cliente.setBairro(endereco.getBairro());
                cliente.setCidade(endereco.getLocalidade());
                cliente.setEstado(endereco.getUf());
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CEP não encontrado!", null));
            }
        }
    }

    public String salvar() {
        try {
            clienteService.salvarCliente(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!", null));
            limparFormulario();
            return "lista?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar cliente!", null));
            return null;
        }
    }

    public String editar(Long id) {
        cliente = clienteService.buscarClientePorId(id);
        return "cadastrar?faces-redirect=true";
    }

    public void excluir(Long id) {
        clienteService.excluirCliente(id);
        clientes = clienteService.listarClientes(); 
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluído com sucesso!", null));
    }

    public void listarClientes() {
        clientes = clienteService.listarClientes();
    }

    public void limparFormulario() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
