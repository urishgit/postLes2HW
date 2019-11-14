package telran.forum.service;

import java.util.List;
import java.util.Set;

import telran.forum.dto.DatePeriodDto;
import telran.forum.dto.NewCommentDto;
import telran.forum.dto.NewPostDto;
import telran.forum.dto.PostDto;
import telran.forum.model.Comment;

public interface ForumService {
	PostDto addNewPost(NewPostDto newPost, String author);

	PostDto getPost(String id);

	PostDto removePost(String id);

	PostDto updatePost(NewPostDto postUpdateDto, String id);

	boolean addLike(String id);

	PostDto addComment(String id, String author, NewCommentDto newCommentDto);

	Iterable<PostDto> findPostsByAuthor(String author);

	Iterable<PostDto>findPostByTags(List<String>tags);
	
    Iterable<PostDto> findByDates(DatePeriodDto datesDto);
    
	Iterable<PostDto> findAllComments(Set<Comment> comments);
	
	Iterable<PostDto> findAllPostCommentsByAuthor(String auther);
}
