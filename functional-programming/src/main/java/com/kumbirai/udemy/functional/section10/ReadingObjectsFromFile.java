package com.kumbirai.udemy.functional.section10;

import com.kumbirai.udemy.functional.section9.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectsFromFile
{
	private static final Logger LOG = LoggerFactory.getLogger(ReadingObjectsFromFile.class);

	public static void main(String[] args)
	{
		//Path path = Paths.get("/Users/mohitsinghal/newWorkspace/Functional-Programming/src/com/basicsstrong/functional/section10/Books");
		URL res = ReadingObjectsFromFile.class.getResource("Books");
		LOG.info("{}",
				res);

		Path path = null;
		try
		{
			path = Paths.get(res.toURI());
		}
		catch (URISyntaxException e)
		{
			LOG.error("Exception Caught: ",
					e);
		}
		try (Stream<String> lines = Files.lines(path))
		{
			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> spliterator = new BookSpliterator(baseSpliterator);

			Stream<Book> stream = StreamSupport.stream(spliterator,
					false);
			stream.forEach(val -> LOG.info("{}",
					val));
		}
		catch (IOException e)
		{
			LOG.error("Exception Caught: ",
					e);
		}
	}
}
