package org.jcgc.jobsearch;

import com.beust.jcommander.JCommander;
import org.jcgc.jobsearch.api.APIJobs;
import org.jcgc.jobsearch.cli.CLIArguments;
import org.jcgc.jobsearch.cli.CLIFunctions;
import org.jcgc.jobsearch.cli.CLIHelpValidator;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.jcgc.jobsearch.CommanderFunctions.buildCommanderWithName;
import static org.jcgc.jobsearch.CommanderFunctions.parseArguments;
import static org.jcgc.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.EMPTY_LIST)
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI.filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
