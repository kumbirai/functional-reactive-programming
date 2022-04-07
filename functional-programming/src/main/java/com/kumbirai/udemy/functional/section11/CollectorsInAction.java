package com.kumbirai.udemy.functional.section11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction
{
	private static final Logger LOG = LoggerFactory.getLogger(CollectorsInAction.class);

	public static void main(String[] args)
	{
		Path path = Paths.get("/Users/mohitsinghal/newWorkspace/Functional-Programming/src/com/basicsstrong/functional/section11/EmployeeData");
		try (Stream<String> lines = Files.lines(path))
		{

			Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> wordSpliterator = words.spliterator();
			Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

			Stream<Employee> employees = StreamSupport.stream(employeeSpliterator,
					false);

			List<Employee> employeeList = employees.collect(Collectors.toList());

			List<String> employeeNames = employeeList.stream()
					.map(employee -> employee.getName())
					.collect(Collectors.toList());

			employeeNames.forEach(val -> LOG.info("{}",
					val));
			LOG.info("-----X-------LIST---------X---");

			Set<String> designations = employeeList.stream()
					.map(e -> e.getDesignation())
					.collect(Collectors.toSet());

			designations.forEach(val -> LOG.info("{}",
					val));
			LOG.info("-----X-------SET---------X---");

			TreeSet<Employee> employeesSorted = employeeList.stream()
					.collect(Collectors.toCollection(TreeSet::new));

			employeesSorted.forEach(val -> LOG.info("{}",
					val));
			LOG.info("-----X-------Collection(TreeSet)---------X---");

			Map<Integer, String> getNameById = employeeList.stream()
					.collect(Collectors.toMap(e -> e.getId(),
							e -> e.getName()));

			LOG.info("{}",
					getNameById);

			Map<Boolean, List<Employee>> partitionedData = employeeList.stream()
					.collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));

			LOG.info("{}",
					partitionedData);

			//List<Employee> maleEmployees = partitionedData.get(true);
			//List<Employee> femaleEmployees = partitionedData.get(false);

			Map<String, List<Employee>> getByDesignation = employeeList.stream()
					.collect(Collectors.groupingBy(e -> e.getDesignation()));

			LOG.info("{}",
					getByDesignation);

			Long collect = employeeList.stream()
					.map(e -> e.getSalary())
					.collect(Collectors.counting());
			LOG.info("{}",
					collect);

			LOG.info("-----X-------Map---------X---");

			String employeeNamesString = employeeList.stream()
					.map(e -> e.getName())
					.collect(Collectors.joining(", "));

			LOG.info(employeeNamesString);

			LOG.info("-----X-------String---------X---");

		}
		catch (IOException e)
		{
			LOG.error("Exception Caught: ",
					e);
		}
	}
}
