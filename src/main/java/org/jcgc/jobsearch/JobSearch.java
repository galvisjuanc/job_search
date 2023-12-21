package org.jcgc.jobsearch;

import com.beust.jcommander.JCommander;
import org.jcgc.jobsearch.cli.CLIArguments;

import static org.jcgc.jobsearch.CommanderFunctions.buildCommanderWithName;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search");
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);
    }
}
