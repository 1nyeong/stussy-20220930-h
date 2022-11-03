package com.stussy.stussyclone20220930h.service;

import com.stussy.stussyclone20220930h.domain.User;
import com.stussy.stussyclone20220930h.repository.AccountRepository;
import com.stussy.stussyclone20220930h.security.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalOauth2Service extends DefaultOAuth2UserService {

    private final AccountRepository accountRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("oAuth2User: {}", oAuth2User.getAttributes());
        log.info("userRequest: {}", userRequest.getClientRegistration());
        String provider = userRequest.getClientRegistration().getClientName();
        PrincipalDetails principalDetails = null;

        try {
            principalDetails = getPrincipalDetails(provider, oAuth2User.getAttributes());
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAuth2AuthenticationException("login failed");
        }

        return principalDetails;
    }

    private PrincipalDetails getPrincipalDetails(String provider, Map<String, Object> attributes) throws Exception {
        User user = null;
        Map<String, Object> oauth2Attributes = null;
        String email = null;

        if(provider.equalsIgnoreCase("google")) {
            oauth2Attributes = attributes;
        }else if(provider.equalsIgnoreCase("naver")) {
            oauth2Attributes = (Map<String, Object>) attributes.get("response");
        }

        email = (String) oauth2Attributes.get("email");

        user = accountRepository.findUserByEmail(email);

        if(user == null) {
            // 회원가입
            user = User.builder()
                    .email(email)
                    .password(new BCryptPasswordEncoder().encode(UUID.randomUUID().toString()))
                    .name((String) oauth2Attributes.get("name"))
                    .provider(provider)
                    .role_id(1)
                    .build();

            accountRepository.saveUser(user);
        } else if (user.getProvider() == null) {
            // 연동
            user.setProvider(provider);
            accountRepository.updateProvider(user);
        } else if (!user.getProvider().contains((provider))){
            user.setProvider(user.getProvider() + "," + provider);
            accountRepository.updateProvider(user);
        }

        return new PrincipalDetails(user, oauth2Attributes);
    }
}