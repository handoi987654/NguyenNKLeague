package com.Desert.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ResultModel {

    @NotNull
    private long matchID;
    @Min(value = 0, message = "Grade can't be less than 0!")
    private int firstGrade;
    @Min(value = 0, message = "Grade can't be less than 0!")
    private int secondGrade;
}
