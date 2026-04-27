package com.devsuperior.crudcliente.dto;

import com.devsuperior.crudcliente.entities.Client;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @Size(min= 3, max=80, message = " Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min= 11, max=11, message = " CPF são 11 digitos")
    @NotBlank(message = "Campo requerido")
    private String cpf;
    @NotNull(message = "Campo requerido")
    @Positive(message= "O Salario tem que ser positivo")
    private Double income;
    @PastOrPresent(message = "A data de nascimento não pode ser uma data futura")
    private LocalDate birthDate;

    private Integer children;

    public ClientDTO(){

    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
