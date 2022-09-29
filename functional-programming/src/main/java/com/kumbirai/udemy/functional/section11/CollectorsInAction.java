package com.kumbirai.udemy.functional.section11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction
{
	private static final Logger LOG = LoggerFactory.getLogger(CollectorsInAction.class);

	public static void main(String[] args)
	{
		//Path path = Paths.get("/Users/mohitsinghal/newWorkspace/Functional-Programming/src/com/basicsstrong/functional/section11/EmployeeData");
		URL res = CollectorsInAction.class.getResource("EmployeeData");
		LOG.info("{}", res);

		Path path = null;
		try
		{
			path = Paths.get(res.toURI());
		}
		catch (URISyntaxException e)
		{
			LOG.error("Exception Caught: ", e);
		}
		try (Stream<String> lines = Files.lines(path))
		{
			Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> wordSpliterator = words.spliterator();
			Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

			Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

			List<Employee> employeeList = employees.collect(Collectors.toList());

			List<String> employeeNames = employeeList.stream()
					.map(employee -> employee.getName())
					.collect(Collectors.toList());

			LOG.info("-----X-------LIST---------X---");
			employeeNames.forEach(val -> LOG.info("{}", val));

			Set<String> designations = employeeList.stream()
					.map(e -> e.getDesignation())
					.collect(Collectors.toSet());

			LOG.info("-----X-------SET---------X---");
			designations.forEach(val -> LOG.info("{}", val));

			TreeSet<Employee> employeesSorted = employeeList.stream()
					.collect(Collectors.toCollection(TreeSet::new));

			LOG.info("-----X-------Collection(TreeSet)---------X---");
			employeesSorted.forEach(val -> LOG.info("{}", val));

			Map<Integer, String> getNameById = employeeList.stream()
					.collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));

			LOG.info("-----X-------Map---------X---");
			LOG.info("{}", getNameById);

			Map<Boolean, List<Employee>> partitionedData = employeeList.stream()
					.collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));

			LOG.info("{}", partitionedData);

			//List<Employee> maleEmployees = partitionedData.get(true)
			//List<Employee> femaleEmployees = partitionedData.get(false)

			Map<String, List<Employee>> getByDesignation = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDesignation));

			LOG.info("{}", getByDesignation);

			Long collect = employeeList.stream()
					.map(e -> e.getSalary())
					.collect(Collectors.counting());
			LOG.info("-----X-------long (count)---------X---");
			LOG.info("{}", collect);

			String employeeNamesString = employeeList.stream()
					.map(e -> e.getName())
					.collect(Collectors.joining(", "));

			LOG.info("-----X-------String---------X---");
			LOG.info(employeeNamesString);

			LOG.info("-----X-------Down Stream Collectors---------X---");
			Map<String, Long> countByDesignation = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDesignation, Collectors.counting()));
			LOG.info("{}", countByDesignation);

			Map<String, Double> totalSalaryByDesignation = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDesignation, Collectors.summingDouble(Employee::getSalary)));
			LOG.info("{}", totalSalaryByDesignation);

			Map<String, Optional<Employee>> highestPaidByDesignation = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDesignation, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
			LOG.info("{}", highestPaidByDesignation);

			Map<String, Optional<Double>> highestSalaryByDesignation = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDesignation, Collectors.mapping(Employee::getSalary, Collectors.maxBy(Comparator.comparing(Function.identity())))));
			LOG.info("{}", highestSalaryByDesignation);
		}
		catch (IOException e)
		{
			LOG.error("Exception Caught: ", e);
		}
	}
}
