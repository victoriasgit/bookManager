package net.proselyte.bookmanager.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;


@Component
public class BookValidator implements Validator {           // проверяет корректность вставляемых данных

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {

        //ValidationUtils для проверки пустых полей объекта
        //предоставляет методы rejectIfEmpty() методы для отклонения пустых полей с кодом ошибки.
        ValidationUtils.rejectIfEmpty(err, "title", "book.title.empty");
        ValidationUtils.rejectIfEmpty(err, "price", "book.price.empty");
        ValidationUtils.rejectIfEmpty(err, "author", "book.author.empty");
        ValidationUtils.rejectIfEmpty(err, "genre", "book.genre.empty");

        Book book = (Book) obj;

    }

}
