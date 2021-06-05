package com.bgouk.hrmsproject.entities.builder;

import com.bgouk.hrmsproject.entities.dtos.JobAdvertisementDetailDto;

import java.time.LocalDateTime;


public class JobAdvertisementDetailBuilder {

    private String jobDescription;

    private Integer minSalary;

    private Integer maxSalary;

    private int quota;

    private LocalDateTime appealDeadline;

    private LocalDateTime updatedDate;

    private boolean isActivated;

    private String employerName;

    private String cityName;

    private String jobTitle;

    public static JobAdvertisementDetailBuilder startBuild(){
        return new JobAdvertisementDetailBuilder();
    }

    public JobAdvertisementDetailBuilder setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public JobAdvertisementDetailBuilder setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
        return this;
    }

    public JobAdvertisementDetailBuilder setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
        return this;
    }

    public JobAdvertisementDetailBuilder setQuota(int quota) {
        this.quota = quota;
        return this;
    }

    public JobAdvertisementDetailBuilder setAppealDeadline(LocalDateTime appealDeadline) {
        this.appealDeadline = appealDeadline;
        return this;
    }

    public JobAdvertisementDetailBuilder setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public JobAdvertisementDetailBuilder setActivated(boolean activated) {
        isActivated = activated;
        return this;
    }

    public JobAdvertisementDetailBuilder setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public JobAdvertisementDetailBuilder setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public JobAdvertisementDetailBuilder setEmployerName(String employerName) {
        this.employerName = employerName;
        return this;
    }

    public JobAdvertisementDetailDto build(){
        return new JobAdvertisementDetailDto(jobDescription,minSalary,maxSalary,quota,appealDeadline,updatedDate,isActivated,employerName ,cityName,jobTitle);
    }
}
