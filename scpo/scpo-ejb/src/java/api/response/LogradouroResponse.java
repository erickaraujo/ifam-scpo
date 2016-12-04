/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.response;

import api.dto.LogradouroDTO;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author erick.araujo
 */
public class LogradouroResponse {
    private List<LogradouroDTO> logradouros;
    
    public LogradouroResponse(List<LogradouroDTO> logradouros){
        this.logradouros = logradouros;
    }
    
    public LogradouroResponse(LogradouroDTO... logradouro){
        this.logradouros= Arrays.asList(logradouro);
    }
    
    public List<LogradouroDTO> getLogradouros(){
        return logradouros;
    }
    
    public void setLogradouros(List<LogradouroDTO> logradouros){
        this.logradouros=logradouros;
    }
}
