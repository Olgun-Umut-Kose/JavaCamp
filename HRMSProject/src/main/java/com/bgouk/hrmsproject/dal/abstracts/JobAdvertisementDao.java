package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    @Query("from JobAdvertisement j where j.isActivated = true and (j.appealDeadline is NULL or j.appealDeadline > :localDateTime)")
    List<JobAdvertisement> findByIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNull(LocalDateTime localDateTime);
    @Query("from JobAdvertisement j where j.isActivated = true and (j.appealDeadline is NULL or j.appealDeadline > :localDateTime) order by j.createdDate desc ")
    List<JobAdvertisement> findByIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNullOrderByCreatedDateDesc(LocalDateTime localDateTime);
    @Query("from JobAdvertisement j inner join j.employer e on e.id = :employerId where j.isActivated = true and (j.appealDeadline is NULL or j.appealDeadline > :localDateTime) order by j.createdDate desc ")
    List<JobAdvertisement> findByAndEmployer_IdAndIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNullOrderByCreatedDateDesc(LocalDateTime localDateTime, int employerId);
    @Query("from JobAdvertisement j inner join j.employer e on e.id = :employerId where j.isActivated = true and (j.appealDeadline is NULL or j.appealDeadline > :localDateTime)")
    List<JobAdvertisement> findByAndEmployer_IdAndIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNull(LocalDateTime localDateTime, int employerId);

}
