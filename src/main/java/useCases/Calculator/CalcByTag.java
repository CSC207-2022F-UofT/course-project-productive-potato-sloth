package useCases.Calculator;

import entities.Tag;
import entities.User;

public interface CalcByTag {
    int rawTimeByTag(User user, String unit, Tag tag);
    int completionByTag(User user, String unit, Tag tag);
}
