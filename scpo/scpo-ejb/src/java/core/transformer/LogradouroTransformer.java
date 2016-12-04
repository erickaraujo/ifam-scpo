/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.transformer;


import api.dto.DTOTransformer;
import api.dto.LogradouroDTO;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import core.modelo.Cidade;
import core.modelo.Logradouro;

/**
 *
 * @author erick.araujo
 */

@ApplicationScoped
public class LogradouroTransformer implements DTOTransformer<Logradouro, LogradouroDTO> {
    
    @Inject
    private CidadeTransformer cidadeTransformer;

    @Override
    public Logradouro toEntity(LogradouroDTO dto) {
        if(dto == null){
            return null;
        }
        
        final Logradouro logradouro = new Logradouro();
        logradouro.setId(dto.getId());
        logradouro.setCep(dto.getCep());
        logradouro.setComplemento(dto.getComplemento());
        logradouro.setBairro(dto.getBairro());
        logradouro.setLocalidade(cidadeTransformer.toEntity(dto.getLocalidade()));
        logradouro.setLogradouro(dto.getLogradouro());
        logradouro.setDescricaoLog(dto.getDescricaoLog());
        
        return logradouro;
    }

    @Override
    public LogradouroDTO toDTO(Logradouro entity) {
        if(entity == null){
            return null;
        }
        
        final LogradouroDTO logradouro = new LogradouroDTO();
        logradouro.setId(entity.getId());
        logradouro.setDescricaoLog(entity.getDescricaoLog());
        logradouro.setBairro(entity.getBairro());
        logradouro.setCep(entity.getCep());
        logradouro.setLocalidade(cidadeTransformer.toDTO(entity.getLocalidade()));
        logradouro.setLogradouro(entity.getLogradouro());
        logradouro.setComplemento(entity.getComplemento());
        
        return logradouro;
    }
    
        public List<Logradouro> toEntityList(List<LogradouroDTO> dtos){
        List<Logradouro> logradouros = new ArrayList();
        
        for(LogradouroDTO dto : dtos){
            logradouros.add(toEntity(dto));
        }
        
        return logradouros;
    }
    
    public List<LogradouroDTO> toDTOList(List<Logradouro> entidades){
        List<LogradouroDTO> dtos = new ArrayList();
        
        for(Logradouro logradouro : entidades){
            dtos.add(toDTO(logradouro));
        }
        
        return dtos;
    }
}
