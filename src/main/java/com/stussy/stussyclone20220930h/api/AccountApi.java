package com.stussy.stussyclone20220930h.api;

import com.stussy.stussyclone20220930h.dto.RegisteReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/account")
@RestController
public class AccountApi {

    @PostMapping("/register")
    public ResponseEntity<?> register(RegisteReqDto registeReqDto){
        System.out.println("회원가입 요청 데이터 : " + registeReqDto);
        return null;
    }

}
