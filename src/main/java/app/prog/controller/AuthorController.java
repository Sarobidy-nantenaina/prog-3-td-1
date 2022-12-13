package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse.AuthorResponse;
import app.prog.controller.response.AuthorResponse.CreateAuthorResponse;
import app.prog.controller.response.AuthorResponse.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    private final AuthorRestMapper authorRestMapper;

    @GetMapping("/authors")
    public ResponseEntity<AuthorResponse> getAuthors() {
        return new  ResponseEntity<AuthorResponse>((AuthorResponse) authorService.getAuthors().stream()
                .map(authorRestMapper::toRest)
                .toList(),HttpStatus.OK);
    }

    @PostMapping("/authors")
    public List<AuthorResponse> createAuthors(@RequestBody List<CreateAuthorResponse> toCreate) {
        List<AuthorEntity> domain = toCreate.stream()
                .map(authorRestMapper::toDomain)
                .toList();
        return authorService.createAuthors(domain).stream()
                .map(authorRestMapper::toRest)
                .toList();
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateAuthors(@RequestBody List<UpdateAuthorResponse> toUpdate) {
        List<AuthorEntity> domain = toUpdate.stream()
                .map(authorRestMapper::toDomain)
                .toList();
        return authorService.updateAuthors(domain).stream()
                .map(authorRestMapper::toRest)
                .toList();
    }

    @DeleteMapping("/authors/{authorId}")
    public AuthorResponse deleteAuthor(@PathVariable Integer authorId) {
        return authorRestMapper.toRest(authorService.deleteAuthor(authorId));
    }
}
