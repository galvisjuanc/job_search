package org.jcgc.jobsearch.cli;

public class CLIArguments {

    CLIArguments() {

    }

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
}
