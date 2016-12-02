/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author erick.araujo
 */
public interface DTOTransformer<E,D> {
    
    E toEntity(D dto);
    
    D toDTO(E entity);
}
