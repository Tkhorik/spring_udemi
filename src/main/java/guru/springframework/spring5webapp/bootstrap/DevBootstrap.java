package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorsRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorsRepository authorsRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorsRepository authorsRepository, BookRepository bookRepository) {
        this.authorsRepository = authorsRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Development", "123", "helper Garis");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        authorsRepository.save(eric);
        bookRepository.save(ddd);
        //Rode
        Author rode = new Author("Rode", "Bush");
        Book bbb = new Book("Domain Driven Testing", "567", "helper Gregory");
        rode.getBooks().add(bbb);
        bbb.getAuthor().add(rode);
        authorsRepository.save(rode);
        bookRepository.save(bbb);
    }
}
