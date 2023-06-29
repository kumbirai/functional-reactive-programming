package com.kumbirai.udemy.functional.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation
{
    private static final Logger LOG = LoggerFactory.getLogger(FlatMapOperation.class);

    public static void main(String[] args)
    {
        Stream<String> a = Stream.of("Hello ",
                                     "there! ");
        Stream<String> b = Stream.of("Learning",
                                     "Java? ");

        Stream<Stream<String>> of = Stream.of(a,
                                              b);

        Stream<String> flatMap = Stream.of(a,
                                           b)
                                       .flatMap(e -> e);

        URL res = FlatMapOperation.class.getResource("The Notebook");
        LOG.info("{}",
                 res);

        Path p = null;
        try
        {
            p = Paths.get(res.toURI());
        }
        catch (URISyntaxException e)
        {
            LOG.error("Exception Caught: ",
                      e);
        }
        Objects.requireNonNull(p,
                               "Path is null");
        try (Stream<String> notebook = Files.lines(p))
        {
            List<String> collect = notebook.flatMap(line -> Arrays.stream(line.split(" ")))
                                           .collect(Collectors.toList());

            collect.forEach(val -> LOG.info("{}",
                                            val));
        }
        catch (IOException e1)
        {
            LOG.error("Exception Caught: ",
                      e1);
        }
    }
}
