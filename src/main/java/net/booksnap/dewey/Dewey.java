package net.booksnap.dewey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dewey {

    @Id
    private String codeDewey;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_code")
    private Dewey parent;

    @OneToMany(mappedBy = "parent")
    private List<Dewey> children;
}