package com.example.demo.entities;

import static javax.persistence.TemporalType.*;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * エンティティ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
public class Todo {
	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/** 内容 */
	@Column(name = "content", length=100)
	private String content;

	/** 終了フラグ */
	@Column(name = "done", nullable = false)
	private Boolean done = false;

	/** 作成日時 */
	@CreatedDate
	@Temporal(TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	/** 更新日時 */
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
}
