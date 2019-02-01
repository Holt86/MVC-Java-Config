package ru.mvc.services;

import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import ru.mvc.entity.tables.Author;
//import ru.mvc.entity.tables.AuthorBook;
//import ru.mvc.entity.tables.Book;
import ru.mvc.models.Message;

//import static ru.mvc.entity.tables.Author.*;
//import static ru.mvc.entity.tables.AuthorBook.AUTHOR_BOOK;
//import static ru.mvc.entity.tables.Book.*;

/**
 * Created by User on 23.01.2019.
 */

@Service
public class MailService {

    @Autowired
    private DSLContext context;


    public Message getMessage(){
//        Result<Record> result =
//                context.select()
//                        .from(AUTHOR)
//                        .join(AUTHOR_BOOK).on(AUTHOR.ID.equal(AUTHOR_BOOK.AUTHOR_ID))
//                        .join(BOOK).on(AUTHOR_BOOK.BOOK_ID.equal(BOOK.ID))
//                        .fetch();


        return new Message("user@mail.ru", "User1");
    }
}
