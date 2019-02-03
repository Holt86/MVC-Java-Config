package ru.mvc.services;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mvc.models.Message;
import ru.mvc.models.ModelAuthor;

import java.util.List;

import static ru.mvc.entity.tables.Author.AUTHOR;
import static ru.mvc.entity.tables.AuthorBook.AUTHOR_BOOK;
import static ru.mvc.entity.tables.Book.BOOK;

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

//        create.selectFrom(BOOK)
//                .orderBy(BOOK.ID)
//                .fetch(new RecordMapper<BookRecord, Integer>() {
//                    @Override
//                    public Integer map(BookRecord book) {
//                        return book.getId();
//                    }
//                });


        List<ModelAuthor> authors = context.select()
                .from(AUTHOR)
                .fetch(record -> {
                    return new ModelAuthor(record.get(AUTHOR.ID), record.get(AUTHOR.FIRST_NAME), record.get(AUTHOR.LAST_NAME));
                });


        return new Message("user@mail.ru", "User1");
    }
}
