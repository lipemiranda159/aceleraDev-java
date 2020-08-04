package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;
	@Autowired
	private NumberGeneratorService numberGeneratorService;

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.findAll();
		return PickOneRandomQuote(quotes);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);
		return PickOneRandomQuote(quotes);
	}

	private Quote PickOneRandomQuote(List<Quote> quotes)  {
		int length = quotes.size();
		if (length > 0) {
			return quotes.get(numberGeneratorService.GetNumber(length));
		} else return new Quote();

	}

}
