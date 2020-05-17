package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by laksheenmendis on 5/17/20 at 12:23 AM
 */

@Component  //tells that this is a Spring managed component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // tells the Spring Framework to inject an instance of AuthorRepository and BookRepository when
    // constructing the bean
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher longman = new Publisher("Longman", "291 Church Street", "Birmingham", "AL", "35226");

        // if we don't save this, we will get an java.lang.IllegalStateException
        // caused by org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException:
        publisherRepository.save(longman);

        Author charolette = new Author("Charolette", "Bronte");
        Book little_women = new Book("Little Women", "123983");

        charolette.getBooks().add(little_women);
        little_women.getAuthors().add(charolette);
        little_women.setPublisher(longman);
        longman.getBooks().add(little_women);

        authorRepository.save(charolette);
        bookRepository.save(little_women);
        publisherRepository.save(longman);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "983792");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(longman);
        longman.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(longman);

        System.out.println("Number of Authors : " + authorRepository.count());
        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }

}
