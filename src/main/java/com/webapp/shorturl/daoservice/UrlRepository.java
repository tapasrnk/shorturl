package com.webapp.shorturl.daoservice;

import com.webapp.shorturl.dao.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {

}