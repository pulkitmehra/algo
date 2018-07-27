package com.algo.problems;

import com.ds.HashFunctions;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class IsbnLruCache {


    @Test
    public void lruCache(){
        Book book1 = Book.get("microservice");
        Book book2 = Book.get("DDD");
        Book book3 = Book.get("SOA");
        Book book4 = Book.get("OAuth");

        BookCache cache = new BookCache(3);

        cache.put(book1.isbn, book1);
        cache.put(book2.isbn, book2);
        cache.put(book3.isbn, book3);
        cache.put(book4.isbn, book4);

        System.out.println(cache);
    }



    static class BookCache extends LinkedHashMap<String,Book>{

        int size = 0;
        BookCache(int size){
            this.size=size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Book> eldest) {
            return size() > size;
        }
    }

    static class Book{
        String title;
        String isbn;

        static Book get(String title){
           Book b =new Book();
           b.title = title;
           b.isbn = key(title);
           return b;
        }

        static String key(String value){
            return HashFunctions.getMd5HashInString(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Objects.equals(isbn, book.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isbn);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
