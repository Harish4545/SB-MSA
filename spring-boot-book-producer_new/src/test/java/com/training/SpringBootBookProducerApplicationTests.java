package com.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Book;
import com.training.repo.BookRepo;
import com.training.services.BookService;
import com.training.services.BookServiceI;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBookProducerApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	 * @Autowired private BookServiceI bookService;
	 * 
	 * @Test public void testHello() { String actualResult=bookService.sayHello();
	 * //hello String expResult="HELLO";
	 * 
	 * assertEquals("Test has not passed",expResult,actualResult);
	 * 
	 * }
	 * 
	 * @Test public void testSum() { assertEquals(26,bookService.sum(12, 14)); }
	 * 
	 * @MockBean private BookRepo bookRepo;
	 * 
	 * @Test public void testGetBooks() { List<Book> list1=LongStream.range(3, 5)
	 * .mapToObj(i->new Book(i, "book"+i, 150.25, 100l))
	 * .collect(Collectors.toList());
	 * 
	 * when(bookRepo.findAll()).thenReturn(list1);
	 * 
	 * assertNotNull(bookService.getBooks());
	 * 
	 * //assertTrue(bookService.getBooks().size()>0); }
	 * 
	 * @Test public void testAddBook() { Book book1=new Book(1234l, "C", 150.25,
	 * 100l);
	 * 
	 * when(bookRepo.save(book1)).thenReturn(book1);
	 * 
	 * assertSame(book1,bookService.addBook(book1)); }
	 * 
	 */

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	//bookstore/api/books
	@Test
	public void getBooksTest() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		MvcResult result= mockMvc
				.perform(get("/bookstore/api/books")
						.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();

		ObjectMapper mapper = new ObjectMapper();
		List<Book> response = mapper.readValue(resultContent,List.class);
		//	System.out.println(response);
		assertNotNull(response);

	}
	@Test
	public void getBookTest() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

		MvcResult result= mockMvc
				.perform(get("/bookstore/api/book/isbn/{isbn}",3214l)
						.content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();

		ObjectMapper mapper = new ObjectMapper();
		Book response = mapper.readValue(resultContent,Book.class);
		assertNotNull(response);
	}
	@Test
	public void addBookTest() throws Exception
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		Book book1=new Book(2379l, "ML", 250.25, 100l);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonBookInput=mapper.writeValueAsString(book1);
		
		MvcResult result = mockMvc
							.perform(post("/bookstore/api/book")
							.content(jsonBookInput)
							.contentType(MediaType.APPLICATION_JSON_VALUE))
							.andExpect(status().isCreated()).andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		Book response = mapper.readValue(resultContent,Book.class);
		assertEquals(book1,response);
				
	}


}




