package telran.forum.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.forum.dto.DatePeriodDto;
import telran.forum.dto.PostDto;
import telran.forum.model.Comment;
import telran.forum.model.Post;

public interface ForumRepository extends MongoRepository<Post, String> {
	Stream<Post> findByAuthor(String author);
	Stream<Post> findByTagsIn(List<String>tags);
	Stream<Post> findByDateCreatedBetween(LocalDate from, LocalDate to);
	Stream<Post> findByCommentsIn(Set<Comment> comments);
	Stream<Post> findBycommentsInAndAuthorIsContaining(String auther);
}
