package com.shinhaninvetment.opendart.repository.dto;

import lombok.Data;
import java.util.ArrayList;

@Data
public class TitleDto {
	private String status;
	private String message;
	private String page_no;
	private String page_count;
	private String total_count;
	private String total_page;
	private ArrayList<Title> list;
}
