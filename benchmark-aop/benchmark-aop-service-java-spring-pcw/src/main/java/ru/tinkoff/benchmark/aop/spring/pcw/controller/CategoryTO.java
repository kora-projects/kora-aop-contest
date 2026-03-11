package ru.tinkoff.benchmark.aop.spring.pcw.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class CategoryTO {

    private Long id;

    private String name;

    public CategoryTO() {
        super();
    }

    public CategoryTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryTO categoryTO = (CategoryTO) o;
        return Objects.equals(this.id, categoryTO.id) &&
                Objects.equals(this.name, categoryTO.name);
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public CategoryTO id(Long id) {
        this.id = id;
        return this;
    }

    public CategoryTO name(String name) {
        this.name = name;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "class CategoryTO {" +
                "    id: " + toIndentedString(id) +
                "    name: " + toIndentedString(name) +
                "}";
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
