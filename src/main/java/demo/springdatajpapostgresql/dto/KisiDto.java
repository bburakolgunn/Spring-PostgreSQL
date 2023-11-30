package demo.springdatajpapostgresql.dto;

import demo.springdatajpapostgresql.entity.Adres;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class KisiDto {

    private Long id;

    @NotNull
    private String adi;


    private String soyadi;


    private List<String> adresleri;

}
