package com.praveen.springbootreceipes.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString; import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request. MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result. MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {

   @Autowired
   public MockMvc mockMvc;

   @MockBean
   public BookService bookService;

   @Test
   public void testShouldRetunAllBooks() throws Exception{
       when(bookService.findAll()).thenReturn(Arrays.asList(
               new Book("1212","skldskl","sdsd","sdsd"),
               new Book("2112","skldska","sdsd","sdsd")
       ));

       mockMvc.perform(get("/books"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$",hasSize(2)))
               .andExpect(jsonPath("[*].isbn", containsInAnyOrder("1212","2112")))
               .andExpect(jsonPath("[*].title", containsInAnyOrder("skldskl","skldska")));
   }

   @Test
   public void testShouldRetunBook () throws Exception{
       when(bookService.find(anyString()))
               .thenReturn(Optional.of(new Book("123", "sdjkslkd", "sdsdssds")));

       mockMvc.perform(get("/books/123"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.isbn",equalTo("123")))
               .andExpect(jsonPath("$.title", equalTo("sdjkslkd")));
   }
}
