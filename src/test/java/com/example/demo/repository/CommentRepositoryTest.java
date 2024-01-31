package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository repository;

	@Test
	public void 댓글등록() {

		Member member = Member.builder().id("chch2857").build();

		Board board = Board.builder().no(1).build();

		Comment comment = Comment.builder().commentNo(1).board(board).content("댓글입니다").writer(member).build();

		repository.save(comment);
	}

	@Test
	public void 댓글목록조회() {

		List<Comment> list = repository.findAll();

		for (Comment comment : list) {
			System.out.println(comment);
		}

	}

	@Test
	public void 댓글단건조회() {
		Optional<Comment> result = repository.findById(1);

		if (result.isPresent()) {
			Comment comment = result.get();
			System.out.println(comment);
		}
	}

	@Test
	public void 댓글수정() {
		Optional<Comment> result = repository.findById(1);

		Comment comment = result.get();

		comment.setContent("댓글수정입니다");

		repository.save(comment);
	}

	@Test
	public void 댓글삭제() {

		repository.deleteById(1);
	}

}
