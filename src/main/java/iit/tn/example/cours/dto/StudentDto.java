package iit.tn.example.cours.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class StudentDto {
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
}
