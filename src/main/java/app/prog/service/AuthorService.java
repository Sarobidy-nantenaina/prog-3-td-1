package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<AuthorEntity> getAuthors (){
        return authorRepository.findAll();
    }

    public List<AuthorEntity> createAuthors(List<AuthorEntity> toCreate) {
        return authorRepository.saveAll(toCreate);
    }

    public List<AuthorEntity> updateAuthors(List<AuthorEntity> toUpdate) {
        return authorRepository.saveAll(toUpdate);
    }

    public AuthorEntity deleteAuthor(int id) {

        Optional<AuthorEntity> optional = authorRepository.findById(id);
        if (optional.isPresent()) {
            authorRepository.delete(optional.get());
            return optional.get();
        } else {
            throw new RuntimeException("BookEntity." + id + " not found");
        }
    }
}
