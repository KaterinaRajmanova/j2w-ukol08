package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //nevím zda může být list a nemusí mít tato metoda ,,podklad,, v repository
    public List<Post> list(){
        return postRepository.findAll();
    }

    public Page<Post> singlePost (String slug, Pageable pageable){
        return postRepository.findPostBySlug(slug,pageable);
    }
}
