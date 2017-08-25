package com.example.demo.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * フォーム
 */
@Data
public class TodoForm {
	/** 内容 */
	@NotNull
	@Size(max = 100)
	private String content;

	/** 終了フラグ */
	private Boolean done;
}
