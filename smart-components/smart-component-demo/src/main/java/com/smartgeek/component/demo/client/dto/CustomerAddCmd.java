package com.smartgeek.component.demo.client.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author  cys
 * for demo
 **/
@Data
public class CustomerAddCmd extends Command {
    @NotBlank
    private String name;

}
