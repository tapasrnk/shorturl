package com.webapp.shorturl.storage.daoservice;

import com.webapp.shorturl.storage.dao.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {

}