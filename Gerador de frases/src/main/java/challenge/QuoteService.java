package challenge;

import org.springframework.http.ResponseEntity;

public interface QuoteService {

	Quote getQuote();
	
	Quote getQuoteByActor(String actor);

}
