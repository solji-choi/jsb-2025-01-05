package com.ll.jsb;

import com.ll.jsb.domain.question.answer.entity.Answer;
import com.ll.jsb.domain.question.answer.repository.AnswerRepository;
import com.ll.jsb.domain.question.question.entity.Question;
import com.ll.jsb.domain.question.question.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JsbApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	@DisplayName("question insert")
	void t1() {
		Question q1  = Question
				.builder()
				.subject("sbb가 무엇인가요?")
				.content("sbb에 대해서 알고 싶습니다.")
				.build();

		questionRepository.save(q1);

		Question q2  = Question
				.builder()
				.subject("스프링부트 모델 질문입니다.")
				.content("id는 자동으로 생성되나요?")
				.build();

		questionRepository.save(q2);
	}

	@Test
	@DisplayName("question findAll")
	void t2() {
		List<Question> all = questionRepository.findAll();

		assertEquals(2, all.size());

		Question q = all.get(0);

		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	@DisplayName("question findById")
	void t3() {
		Optional<Question> oq = questionRepository.findById(1L);

		if(oq.isPresent()) {
			Question q = oq.get();

			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

	@Test
	@DisplayName("question findBySubject")
	void t4() {
		Question q = questionRepository.findBySubject("sbb가 무엇인가요?");

		assertEquals(1, q.getId());
	}

	@Test
	@DisplayName("question findBySubjectAndContent")
	void t5() {
		Question q = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");

		assertEquals(1, q.getId());
	}

	@Test
	@DisplayName("question findBySubjectLike")
	void t6() {
		List<Question> qList = questionRepository.findBySubjectLike("sbb%");

		Question q = qList.get(0);

		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	@DisplayName("question modify")
	void t7() {
		Optional<Question> oq = questionRepository.findById(1L);

		assertTrue(oq.isPresent());

		Question q = oq.get();

		q.setSubject("수정된 제목");

		questionRepository.save(q);
	}

	@Test
	@DisplayName("question delete")
	void t8() {
		assertEquals(2, questionRepository.count());

		Optional<Question> oq = questionRepository.findById(1L);

		assertTrue(oq.isPresent());

		Question q = oq.get();

		questionRepository.delete(q);

		assertEquals(1, questionRepository.count());
	}

	@Test
	@DisplayName("answer insert")
	void t9() {
		Optional<Question> oq = questionRepository.findById(2L);

		assertTrue(oq.isPresent());

		Question q = oq.get();

		Answer a = Answer
				.builder()
				.content("네")
				.question(q)
				.build();

		answerRepository.save(a);
	}

	@Test
	@DisplayName("answer findById")
	void t10() {
		Optional<Answer> oa = answerRepository.findById(1L);

		assertTrue(oa.isPresent());

		Answer a = oa.get();

		assertEquals(2, a.getQuestion().getId());
	}

	@Test
	@DisplayName("find answer from question")
	@Transactional
	void t11() {
		Optional<Question> oq = questionRepository.findById(2L);

		assertTrue(oq.isPresent());

		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네", answerList.get(0).getContent());
	}
}
