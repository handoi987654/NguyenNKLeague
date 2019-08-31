package com.Desert.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlayerModel {

    @NotNull(message = "Please enter a valid name!")
    private String name;
    @NotNull(message = "Please choose a club!")
    private long clubID;
}
