package app.prog.controller.response.BookResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateBookResponse {
    private String author;
    private String title;
}
