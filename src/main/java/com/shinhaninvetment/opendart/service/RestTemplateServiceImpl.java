package com.shinhaninvetment.opendart.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shinhaninvetment.opendart.repository.dto.Title;
import com.shinhaninvetment.opendart.repository.dto.TitleDto;
import com.shinhaninvetment.opendart.repository.TitleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Service
public class RestTemplateServiceImpl implements RestTemplateService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TitleRepository titleRepository;

	@Override
	public TitleDto getTitleList () throws Exception {
		return restTemplate.getForObject("http://opendart.fss.or.kr/api/list.json?crtfc_key=78e0a29a868ebd79a0967e9b0711c1efb32707e2", TitleDto.class);
		
	}
	
	@Override
	@Scheduled(fixedRateString="5000")
	public void schedule() throws Exception {
		TitleDto titleDto = this.getTitleList();
		logger.info(titleDto.toString());
		ArrayList<Title> titleList = titleDto.getList();
		Iterator<Title> iter = titleList.iterator();
		while (iter.hasNext()) {
			Title title = iter.next();
			try {
				titleRepository.insert(title);
			} catch (Exception e) {
			}
		}
	}
}
