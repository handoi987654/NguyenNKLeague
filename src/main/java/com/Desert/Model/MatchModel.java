package com.Desert.Model;

import com.Desert.Validator.DifferentClub;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@DifferentClub
public class MatchModel {

    @NotNull(message = "Please choose a team!")
    private Long firstClubID;
    @NotNull(message = "Please choose a team!")
    private Long secondClubID;
    @NotNull(message = "Invalid date!")
    private Date date;
}
