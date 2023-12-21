package org.jcgc.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    CLIArguments() {

    }

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD"
    )
    private String keyword;

    private String location;

    private int page = 0;

    private boolean isFullTime = false;

    private boolean isMarkdown = false;

    private boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}