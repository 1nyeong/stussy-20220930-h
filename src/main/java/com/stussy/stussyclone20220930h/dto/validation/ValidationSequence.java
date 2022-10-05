package com.stussy.stussyclone20220930h.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ValidationGroups.NotBlankGroups.class,
        ValidationGroups.SizeGroups.class,
        ValidationGroups.PatternCheckGroups.class,
        Default.class
})
public class ValidationSequence {

}
