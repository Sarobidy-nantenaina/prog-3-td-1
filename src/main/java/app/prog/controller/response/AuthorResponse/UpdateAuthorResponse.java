package app.prog.controller.response.AuthorResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateAuthorResponse {

    private int id;
    private String name;
    private String particularity;

}
