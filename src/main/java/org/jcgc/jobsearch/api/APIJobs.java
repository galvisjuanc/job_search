package org.jcgc.jobsearch.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.jcgc.jobsearch.JobPosition;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface APIJobs {

    @RequestLine("GET /positions.json")
    List<JobPosition> jobs (@QueryMap Map<String, Object> queryMap);
}
