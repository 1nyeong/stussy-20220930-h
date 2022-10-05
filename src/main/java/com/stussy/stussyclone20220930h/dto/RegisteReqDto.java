package com.stussy.stussyclone20220930h.dto;

import com.stussy.stussyclone20220930h.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisteReqDto {
    //한글자 이상 무조건 들어와야함, 세글자를 넘을 수는 없다. 무조건 한글이여야한다.
    @NotBlank(message = "이름은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroups.class)
    @Size(min = 1, max = 3, message = "이름은 3자까지만 입력가능합니다", groups = ValidationGroups.SizeGroups.class)
    @Pattern(regexp = "^[가-힇]*&", message = "한글만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroups.class)
    private String lastName;

    @NotBlank(message = "성은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroups.class)
    @Size(min = 1, max = 2, message = "성은 2자까지만 입력가능합니다", groups = ValidationGroups.SizeGroups.class)
    @Pattern(regexp = "^[가-힇]*&", message = "한글만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroups.class)
    private String firstName;
    
    @NotBlank(message = "이메일은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroups.class)
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroups.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자 부터 16자까지 입력가능합니다", groups = ValidationGroups.SizeGroups.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_](8,16)&", message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함해야합니다", groups = ValidationGroups.PatternCheckGroups.class)
    private String password;
}
