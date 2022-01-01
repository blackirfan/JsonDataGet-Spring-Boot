package com.example.jsonsavedemo.model;


//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author Md. Emran Hossain
 * @since 23 Dec, 2021
 *
 */
@Data
@NoArgsConstructor

@Entity
@Table(name = "parents")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Integer id;

    @Column(length = 32, nullable = false)
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Child> children;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Bio bio;

    public Parent(String name, List children, Bio bio) {
        this.name = name;
        this.children = children;
        this.bio = bio;
    }
}
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Child implements Serializable {
//    private String name;
//}
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Bio implements Serializable {
//    private String text;
//}
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
//public class TamLevel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    private String name;
//
//    @NotNull
//    private String json;
//}
