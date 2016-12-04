/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.transformer;

import api.dto.DTOTransformer;
import api.dto.EstadoDTO;
import java.util.ArrayList;
import java.util.List;
import core.modelo.Estado;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author erick.araujo
 */

@ApplicationScoped
public class EstadoTransformer implements DTOTransformer<Estado, EstadoDTO>{

    @Override
    public Estado toEntity(EstadoDTO dto) {
        if(dto == null){
            return null;
        }
        
        final Estado estado = new Estado();
        
        estado.setId(dto.getId());
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());
        
        return estado;
    }

    @Override
    public EstadoDTO toDTO(Estado entidade) {
        if(entidade == null){
            return null;
        }
        
        final EstadoDTO estado = new EstadoDTO();
        estado.setId(entidade.getId());
        estado.setNome(entidade.getNome());
        estado.setSigla(entidade.getSigla());
        
        return estado;
    }
    
    public List<Estado> toEntityList(List<EstadoDTO> dtos){
        List<Estado> estados = new ArrayList();
        
        for(EstadoDTO dto : dtos){
            estados.add(toEntity(dto));
        }
        
        return estados;
    }
    
    public List<EstadoDTO> toDTOList(List<Estado> entidades){
        List<EstadoDTO> dtos = new ArrayList();
        
        for(Estado estado : entidades){
            dtos.add(toDTO(estado));
        }
        
        return dtos;
    }
    
}
