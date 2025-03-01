package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_author")
    private AuthorEntity author;
    private Integer pageNumber;
    private LocalDate releaseDate;

    public boolean hasAuthor() {
        return author != null;
    }

}
