package com.mro.quotation.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class for the QuoteController. The QuoteController provides an API for the frontend server to connect to.
 * Quotes are passed and received using JSON format.
 * RestController signifies this is a Controller object for use by Springboot.
 * RequestMapping is the location where transactions take place. (eg; http://localhost:8080/api/quotes)
 * CrossOrigin is for security. <<--- this will have to be changed later !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * @author Chris Durnan
 */
@RestController
@RequestMapping(path = "api/quotes")
@CrossOrigin("*")
public class QuoteController {
    private final QuoteRepository quoteRepository;

    /**
     * Instantiates QuoteRepository in order for database transactions to occur.
     * @param quoteRepository An instance of QuoteRepository.
     */
    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    /**
     * GET method. Calls on findAll() on quoteRepository to return a list of Quotes.
     * GetMapping is the location where these
     * can be received from the frontend. (eg; http://localhost:8080/api/quotes/getquotes)
     *
     * @return Returns a list of all of the Quotes in the database.
     */
    @GetMapping("/getquotes")
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    /**
     * POST method. Calls on save(quote) on quoteRepository to save the Quote passed to it.
     * PostMapping is the location where these
     * can be sent to. (eg; http://localhost:8080/api/quotes/addquotes)
     */
    @PostMapping("/addquote")
    public void addQuote(@RequestBody Quote quote) {
        quoteRepository.save(quote);
    }
}
