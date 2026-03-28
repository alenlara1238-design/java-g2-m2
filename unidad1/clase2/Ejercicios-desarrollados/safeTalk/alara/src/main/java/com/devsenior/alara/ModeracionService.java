package com.devsenior.alara;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.alara.model.EstadoPost;
import com.devsenior.alara.model.Post;
import com.devsenior.alara.repository.PalabraProhibidaRepository;
import com.devsenior.alara.repository.PostRepository;

@Service
public class ModeracionService {

    private final PostRepository postRepository;
    private final PalabraProhibidaRepository palabraRepo;

    public ModeracionService(PostRepository postRepository, PalabraProhibidaRepository palabreRepo){
        this.postRepository = postRepository;
        this.palabraRepo = palabreRepo;
    }

    public Post crearPost(String contenido){
        List<String> palabrasProhibidas =palabraRepo.obtenerPalabras();

        //detectar si contiene palabras prohibidas
        boolean contieneProhibidas = palabrasProhibidas.stream()
                                .anyMatch(p -> contenido.toLowerCase().contains(p));
        
         String contenidoFinal = contenido;
         
         if(contieneProhibidas){
            contenidoFinal = palabrasProhibidas.stream()
                            .reduce(contenido, 
                                (texto, palabra) -> texto.replaceAll("(?i)" + palabra, "****"));        
         }

         EstadoPost estado = contieneProhibidas ? EstadoPost.MODERADO: EstadoPost.SEGURO;

         Post post = new Post(null, contenidoFinal, estado);

         return postRepository.guardar(post);
    }

    //filtrar solo post seguros

    //obtener todos los post...


}
