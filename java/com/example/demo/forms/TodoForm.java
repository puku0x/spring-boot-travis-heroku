package com.example.demo.forms;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * フォーム
 */
@Data
public class TodoForm {
	/** 内容 */
	@Size(max = 100)
	private String content;
}
