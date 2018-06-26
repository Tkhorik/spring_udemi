package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorsRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorsRepository authorsRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorsRepository authorsRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorsRepository = authorsRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Development", "123", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        authorsRepository.save(eric);
        bookRepository.save(ddd);
        //Rode
        Author rode = new Author("Rode", "Bush");
        Book bbb = new Book("Domain Driven Testing", "567", publisher);
        rode.getBooks().add(bbb);
        bbb.getAuthor().add(rode);
        authorsRepository.save(rode);
        bookRepository.save(bbb);
    }
}
