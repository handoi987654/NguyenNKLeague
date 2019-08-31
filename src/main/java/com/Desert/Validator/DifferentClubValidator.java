package com.Desert.Validator;

import com.Desert.Model.MatchModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DifferentClubValidator implements ConstraintValidator<DifferentClub, MatchModel> {

    private String message;

    @Override
    public void initialize(DifferentClub differentClub) {
        this.message = differentClub.message();
    }

    @Override
    public boolean isValid(MatchModel matchModel, ConstraintValidatorContext context) {
        boolean valid = !(matchModel.getFirstClubID() == matchModel.getSecondClubID());
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("secondClubID")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
