/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.transformer;

import api.dto.DTOTransformer;
import api.dto.PessoaDTO;
import core.modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author erick.araujo
 */
@ApplicationScoped
public class PessoaTransformer implements DTOTransformer<Pessoa, PessoaDTO> {

    @Inject
    private LogradouroTransformer logradouroTransformer;

    @Override
    public Pessoa toEntity(PessoaDTO dto) {
        if (dto == null) {
            return null;
        }

        final Pessoa pessoa = new Pessoa();

        pessoa.setId(dto.getId());
        pessoa.setEmail(dto.getEmail());
        pessoa.setLogradouro(logradouroTransformer.toEntity(dto.getLogradouro()));
        pessoa.setNascimento(dto.getNascimento());
        pessoa.setNome(dto.getNome());
        pessoa.setOcupacao(dto.getOcupacao());
        pessoa.setSexo(dto.getSexo());

        return pessoa;
    }

    @Override
    public PessoaDTO toDTO(Pessoa entity) {
        if (entity == null) {
            return null;
        }

        final PessoaDTO pessoa = new PessoaDTO();
        pessoa.setId(entity.getId());
        pessoa.setEmail(entity.getEmail());
        pessoa.setLogradouro(logradouroTransformer.toDTO(entity.getLogradouro()));
        pessoa.setNascimento(entity.getNascimento());
        pessoa.setNome(entity.getNome());
        pessoa.setOcupacao(entity.getOcupacao());
        pessoa.setSexo(entity.getSexo());

        return pessoa;
    }

    public List<Pessoa> toEntityList(List<PessoaDTO> dtos) {
        List<Pessoa> pessoas = new ArrayList();

        for (PessoaDTO dto : dtos) {
            pessoas.add(toEntity(dto));
        }

        return pessoas;
    }

    public List<PessoaDTO> toDTOList(List<Pessoa> entidades) {
        List<PessoaDTO> dtos = new ArrayList();

        for (Pessoa pessoa : entidades) {
            dtos.add(toDTO(pessoa));
        }

        return dtos;
    }
}
