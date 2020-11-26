package com.shinhaninvetment.opendart.service;

import com.shinhaninvetment.opendart.repository.dto.TitleDto;

public interface RestTemplateService {
	TitleDto getTitleList () throws Exception;
	void schedule() throws Exception;
}
