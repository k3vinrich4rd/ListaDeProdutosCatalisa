package com.aula42.listaDeProdutos.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Model: responsável pela lógica do banco de dados
//Anotações que serve para toda a classe, é sempre acima do "public class"
@Getter // Getters para acessar
@Setter // Setter para definir
@AllArgsConstructor //Constructor com argumentos
@NoArgsConstructor //Constructor sem argumentos
@Entity // Significa que a classe é uma entidade
@Table(name = "produtos")
public class ProdutosModel {

    //Atributos
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar valor (automaticamente)/ E de forma gradual
    private Long codigo;

    @Column(length = 100, nullable = false )
    private String nome;

    @Column(length = 10, nullable = false) // Fazer para cada atributo o @Column (para especificar)/ menos no id
    private Double valor;
}
