package ru.tinkoff.benchmark.aop.spring.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import org.springframework.lang.Nullable;

public class PetTO {

    public enum StatusEnum {

        AVAILABLE("available"),

        PENDING("pending"),

        SOLD("sold");

        private final String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private @Nullable CategoryTO category;

    private Long id;

    private String name;

    private @Nullable StatusEnum status;

    public PetTO() {
        super();
    }

    public PetTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PetTO create(String id) {
        long parsed = Long.parseLong(id);
        return new PetTO()
                .id(parsed + 1)
                .name("bench" + id)
                .status(StatusEnum.AVAILABLE)
                .category(new CategoryTO(parsed + 2, "Category" + id));
    }

    public PetTO category(@Nullable CategoryTO category) {
        this.category = category;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PetTO petTO = (PetTO) o;
        return Objects.equals(this.status, petTO.status) &&
                Objects.equals(this.id, petTO.id) &&
                Objects.equals(this.name, petTO.name) &&
                Objects.equals(this.category, petTO.category);
    }

    @JsonProperty("category")
    public @Nullable CategoryTO getCategory() {
        return category;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("status")
    public @Nullable StatusEnum getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, id, name, category);
    }

    public PetTO id(Long id) {
        this.id = id;
        return this;
    }

    public PetTO name(String name) {
        this.name = name;
        return this;
    }

    public void setCategory(@Nullable CategoryTO category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(@Nullable StatusEnum status) {
        this.status = status;
    }

    public PetTO status(@Nullable StatusEnum status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "class PetTO {" +
                "    status: " + toIndentedString(status) +
                "    id: " + toIndentedString(id) +
                "    name: " + toIndentedString(name) +
                "    category: " + toIndentedString(category) +
                "}";
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
