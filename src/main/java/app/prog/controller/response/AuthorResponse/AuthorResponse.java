package app.prog.controller.response.AuthorResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthorResponse {

    private int id;
    private String name;
    private String particularity;
    private boolean hasParticularity;

}
